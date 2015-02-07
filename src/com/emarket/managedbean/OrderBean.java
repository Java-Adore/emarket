package com.emarket.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

import com.emarket.business.facade.EmarketFacade;
import com.emarket.domain.ShoppingCart;
import com.emarket.general.Constants;
import com.emarket.utils.WebUtils;

@ManagedBean
@SessionScoped
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	EmarketFacade memberFacade;
	

	@PostConstruct
	public void init() {
		
		
	}
	
	
	
	public void makeOrder()
	{
		ShoppingCart shoppingCart = getCurrentShoppingCart();
		if(shoppingCart !=null)
		{
			memberFacade.handleShoppingCart(shoppingCart, WebUtils.getCurrentUser());
		}
		
	}
	
	public ShoppingCart getCurrentShoppingCart()
	{
		return (ShoppingCart)WebUtils.extractFromSession(Constants.CURRENT_SHOPING_CART);
	}
	

}
