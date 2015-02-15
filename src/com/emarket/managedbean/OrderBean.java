package com.emarket.managedbean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.print.attribute.standard.Severity;

import com.emarket.business.facade.EmarketFacade;
import com.emarket.domain.IllegalStateTransitionException;
import com.emarket.domain.OrderItem;
import com.emarket.domain.OrderStatus;
import com.emarket.domain.Product;
import com.emarket.domain.ShoppingCart;
import com.emarket.domain.User;
import com.emarket.general.Constants;
import com.emarket.utils.WebUtils;

@ManagedBean
@SessionScoped
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	EmarketFacade memberFacade;

	// private ShoppingCart currentShoppingCart;

	private Product productToEdit;
	private Integer productToEditAmount;

	public String orderStatus;

	@PostConstruct
	public void init() {
		orderStatus = "---- Select Status ----";
	}

	public void makeOrder() {
		ShoppingCart shoppingCart = getCurrentShoppingCart();
		if (shoppingCart != null) {
			try {
				memberFacade.handleShoppingCart(shoppingCart);
			} catch (IllegalStateTransitionException e) {
				
				e.printStackTrace();
			}
		}

	}

	public ShoppingCart getCurrentShoppingCart() {
		if (AllProductsBean.currentShoppingCart == null)
			AllProductsBean.currentShoppingCart = new ShoppingCart();

		return AllProductsBean.currentShoppingCart;
	}

	public Product getProductToEdit() {
		return productToEdit;
	}

	public void setProductToEdit(Product productToEdit) {
		this.productToEdit = productToEdit;
	}

	public Integer getProductToEditAmount() {
		return productToEditAmount;
	}

	public void setProductToEditAmount(Integer productToEditAmount) {
		this.productToEditAmount = productToEditAmount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public void orderStatusChanged() {
		try {
			if (orderStatus.equals(OrderStatus.COMPLETED))
				AllProductsBean.currentShoppingCart
						.setCompleted(OrderStatus.COMPLETED);
			else
				AllProductsBean.currentShoppingCart
						.setCompleted(OrderStatus.FILLED);

		} catch (IllegalStateTransitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void editProductAmountInCart(Product product, Integer amount) {
		productToEdit = product;
		Map<Product, Integer> orders = getCurrentShoppingCart().getOrders();
		orders.put(product, amount);
		AllProductsBean.currentShoppingCart.setOrders(orders);
		// WebUtils.injectIntoSession(Constants.CURRENT_SHOPING_CART,
		// AllProductsBean.currentShoppingCart.getNumberOfItems());
	}

	public void deleteProductInCart(Product product) {
		AllProductsBean.currentShoppingCart.removeFromCart(product);
		// WebUtils.injectIntoSession(Constants.CURRENT_SHOPING_CART,
		// AllProductsBean.currentShoppingCart);
	}

	public void initialProductAndAmount(Product product) {
		productToEdit = product;
		productToEditAmount = AllProductsBean.currentShoppingCart.getOrders()
				.get(product);
	}

	public void checkOut() {
		try {
			if (orderStatus.equals("---- Select Status ----"))
				WebUtils.fireMessage(FacesMessage.SEVERITY_ERROR,
						"You must Select an Order Status.");
			else {
				StringBuilder content = new StringBuilder();
				if (orderStatus.equals(OrderStatus.COMPLETED.toString())){
					//save it in database
					content.append("\nCOMPLETED STATUS - Date = "+new Date()+"\n");
					Product pro = null;
					boolean saveInDB = true;
					
					for(Product product :AllProductsBean.currentShoppingCart.getOrders().keySet()){
						pro = memberFacade.getProduct(product);
						if(pro.getAmount()<AllProductsBean.currentShoppingCart.getOrders().get(product)){
							WebUtils.fireMessage(FacesMessage.SEVERITY_ERROR,
									"We are so sorry, But the actual amount of this product("+product.getName()+") in our stock is "+pro.getAmount()+
									" so please make sure the max amount of this product is "+pro.getAmount()+" or cancel this product from your cart. Thanks:)");
							saveInDB = false;
						}
						
						System.out.println("product.getProductType() = " + product.getProductType());
					}
					if(saveInDB){
						OrderItem orderItem=new OrderItem();
						for(Product product: AllProductsBean.currentShoppingCart.getOrders().keySet()){
							orderItem.setName(product.getName());
							orderItem.setPrice(product.getPrice());
							orderItem.setAmount(AllProductsBean.currentShoppingCart.getOrders().get(product));
							saveOrderItemInDB(orderItem);
							updateproductAmount(product, AllProductsBean.currentShoppingCart.getOrders().get(product));
							
							content.append("Product Name = " + product.getName() + 
									"\t\t" + "Product Type = " + product.getProductType() + "\t\t" + 
									"Product Amount = " +AllProductsBean.currentShoppingCart.getOrders().get(product)+"\n");
						}
					}
					
				}else{
					content.append("\nNOT COMPLETED  STATUS - Date = "+new Date()+"\n");
					for(Product product: AllProductsBean.currentShoppingCart.getOrders().keySet()){
						content.append("Product Name = " + product.getName() + 
								"\t\t" + "Product Type = " + product.getProductType() + "\t\t" + 
								"Product Amount = " +AllProductsBean.currentShoppingCart.getOrders().get(product)+"\n");
					}
				}
				User user = (User)WebUtils.extractFromSession(Constants.CURRENT_LOGGED_USER);
				String path = "../Invoices" + File.separator + user.getUserName()+"Invoice.txt";
				File file = new File(path);
				file.getParentFile().mkdirs();
				file.createNewFile();
				
				FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(content.toString());
				bw.close();
				
				System.out.println("file.path() = " + file.getAbsolutePath());
				
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	private void saveOrderItemInDB(OrderItem orderItem){
		memberFacade.saveOrderItemInDB(orderItem);
	}
	private void updateproductAmount(Product product, Integer newAmount){
		memberFacade.updateproductAmount(product, newAmount);
	}
}
