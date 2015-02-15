package com.emarket.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.emarket.business.facade.EmarketFacade;
import com.emarket.domain.*;
import com.emarket.utils.WebUtils;

@ManagedBean
@ViewScoped
public class AllProductsBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	EmarketFacade emarketFacade;

	private List<Honey> honeyList;
	private List<Miscellaneous> miscellaneousList;
	private List<Wax> waxList;
	private List<Product> allProducts;

	private Product selectedProduct;
	public static ShoppingCart currentShoppingCart;

	public List<String> orderStatus;

	@PostConstruct
	public void init() {
		honeyList = emarketFacade.getAllHoneyProducts();
		miscellaneousList = emarketFacade.getAllMiscellaneousProducts();
		waxList = emarketFacade.getAllWaxProducts();
		allProducts = new ArrayList<>();
		if (honeyList != null && honeyList.size() > 0)
			allProducts.addAll(honeyList);
		if (waxList != null && waxList.size() > 0)
			allProducts.addAll(waxList);
		if (miscellaneousList != null && miscellaneousList.size() > 0)
			allProducts.addAll(miscellaneousList);

		orderStatus = new ArrayList<>();
		
		orderStatus.add("---- Select Status ----");
		orderStatus.add(OrderStatus.COMPLETED.toString());
		orderStatus.add("Not Completed");
		
//		int i = 0;
//		for (OrderStatus status : OrderStatus.values()) {
//			orderStatus[i] = status.toString();
//			i++;
//		}
	}

	public EmarketFacade getEmarketFacade() {
		return emarketFacade;
	}

	public void setEmarketFacade(EmarketFacade emarketFacade) {
		this.emarketFacade = emarketFacade;
	}

	public List<Honey> getHoneyList() {
		return honeyList;
	}

	public void setHoneyList(List<Honey> honeyList) {
		this.honeyList = honeyList;
	}

	public List<Miscellaneous> getMiscellaneousList() {
		return miscellaneousList;
	}

	public void setMiscellaneousList(List<Miscellaneous> miscellaneousList) {
		this.miscellaneousList = miscellaneousList;
	}

	public List<Wax> getWaxList() {
		return waxList;
	}

	public void setWaxList(List<Wax> waxList) {
		this.waxList = waxList;
	}

	public List<Product> getAllProducts() {
		return allProducts;
	}

	public void setAllProducts(List<Product> allProducts) {
		this.allProducts = allProducts;
	}

	public Product getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(Product selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public List<String> getOrderStatus() {
		return orderStatus;
	}

	public void addToCart(Product selectedProduct) {

		ShoppingCart shoppingCart = AllProductsBean.currentShoppingCart;
		if (AllProductsBean.currentShoppingCart == null) {
			AllProductsBean.currentShoppingCart = new ShoppingCart();
		}
		AllProductsBean.currentShoppingCart.addToCart(selectedProduct);
		// WebUtils.injectIntoSession(Constants.CURRENT_SHOPING_CART,
		// shoppingCart);
		WebUtils.invokeJavaScriptFunction("updateCountForm()");
		WebUtils.fireInfoMessage("PRODUCT_ADDED_TO_SHOPPING_CART");

	}

	public ShoppingCart getCurrentShoppingCart() {
		try {
			// return
			// (ShoppingCart)WebUtils.extractFromSession(Constants.CURRENT_SHOPING_CART);
			if (currentShoppingCart == null) {
				currentShoppingCart = new ShoppingCart();

				currentShoppingCart.setCompleted(OrderStatus.EMPTY);

			}

		} catch (IllegalStateTransitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentShoppingCart;
	}

	public int numberOfItems() {
		
		return getCurrentShoppingCart().getNumberOfItems();

	}
}
