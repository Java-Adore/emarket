package com.emarket.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.emarket.dao.FlowerDAO;
import com.emarket.dao.HoneyDAO;
import com.emarket.dao.MiscellaneousDAO;
import com.emarket.dao.OrderDAO;
import com.emarket.dao.UserDAO;
import com.emarket.dao.WaxDAO;
import com.emarket.domain.Flower;
import com.emarket.domain.Honey;
import com.emarket.domain.Miscellaneous;
import com.emarket.domain.Order;
import com.emarket.domain.OrderItem;
import com.emarket.domain.Product;
import com.emarket.domain.Wax;

@Stateless
public class ProductServiceImpl implements ProductService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	HoneyDAO honeyDAO;
	
	@EJB
	FlowerDAO flowerDAO;
	
	@EJB
	MiscellaneousDAO miscellaneousDAO;
	
	@EJB
	WaxDAO waxDAO;
	
	@EJB
	OrderDAO orderDAO;
	
	
	
	

	@Override
	public List<Flower> getAllFlowersProducts() {
		
		return flowerDAO.getAllProducts();
	}

	@Override
	public Flower addNewFlowerProduct(Flower product) {
		
		return flowerDAO.addNewProduct(product);
	}

	@Override
	public List<Wax> getAllWaxProducts() {
		
		return waxDAO.getAllProducts();
	}

	@Override
	public Wax addNewWaxProduct(Wax product) {
		
		return waxDAO.addNewProduct(product);
	}

	@Override
	public List<Miscellaneous> getAllMiscellaneousProducts() {
		
		return miscellaneousDAO.getAllProducts();
	}

	@Override
	public Miscellaneous addNewProduct(Miscellaneous product) {
		
		return miscellaneousDAO.addNewProduct(product);
	}

	@Override
	public List<Honey> getAllHoneyProducts() {
		
		return honeyDAO.getAllProducts();
	}

	@Override
	public Honey addNewHoneyProduct(Honey product) {
		
		return honeyDAO.addNewProduct(product);
	}

	@Override
	public Order addNewOrder(Order order) {
		return orderDAO.addNewOrder(order);
	}

	@Override
	public void addNewOrderItem(OrderItem orderItem) {
		orderDAO.addNewOrderItem(orderItem);
		
	}

	@Override
	public Product getProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	

	
 
	

}
