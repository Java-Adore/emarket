package com.emarket.business.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.Flower;
import com.emarket.domain.Honey;
import com.emarket.domain.Miscellaneous;
import com.emarket.domain.Order;
import com.emarket.domain.OrderItem;
import com.emarket.domain.Product;
import com.emarket.domain.Wax;

@Local
public interface ProductService extends Serializable {

	/**
	 * 
	 */

	List<Flower> getAllFlowersProducts();

	Flower addNewFlowerProduct(Flower product);

	List<Wax> getAllWaxProducts();

	Wax addNewWaxProduct(Wax product);

	List<Miscellaneous> getAllMiscellaneousProducts();

	Miscellaneous addNewProduct(Miscellaneous product);

	List<Honey> getAllHoneyProducts();

	Honey addNewHoneyProduct(Honey product);

	Order addNewOrder(Order order);

	void addNewOrderItem(OrderItem orderItem);
	
	Product getProduct(Product product);

}
