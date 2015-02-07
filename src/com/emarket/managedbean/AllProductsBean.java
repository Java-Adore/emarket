package com.emarket.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.hibernate.dialect.FirebirdDialect;

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

	@PostConstruct
	public void init() {
		honeyList = emarketFacade.getAllHoneyProducts();
		miscellaneousList = emarketFacade.getAllMiscellaneousProducts();
		waxList = emarketFacade.getAllWaxProducts();
		allProducts = new ArrayList<>();
		if(honeyList!=null && honeyList.size()>0)
			allProducts.addAll(honeyList);
		if(waxList!=null && waxList.size()>0)
			allProducts.addAll(waxList);
		if(miscellaneousList!=null && miscellaneousList.size()>0)
			allProducts.addAll(miscellaneousList);
		
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

	public void addToCart(Product selectedProduct){
		System.out.println("productID = " + selectedProduct.getID());
		System.out.println("================ addToChart() ============");
	}
	
}
