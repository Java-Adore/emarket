package com.emarket.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.emarket.business.facade.EmarketFacade;
import com.emarket.domain.ShoppingCart;

@ManagedBean
@ViewScoped
public class OrderBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	EmarketFacade memberFacade;
	

	@PostConstruct
	public void init() {
		

	}
	
	public void makeOrder(ShoppingCart shoppingCart){
		
	}

}
