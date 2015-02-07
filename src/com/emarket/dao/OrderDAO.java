package com.emarket.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.Flower;
import com.emarket.domain.Honey;
import com.emarket.domain.Order;
import com.emarket.domain.OrderItem;
import com.emarket.domain.Product;

@Local
public interface OrderDAO extends Serializable{

	public Order addNewOrder(Order order);

	public void addNewOrderItem(OrderItem orderItem);

	

}
