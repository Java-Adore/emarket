package com.emarket.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.Honey;
import com.emarket.domain.OrderItem;
import com.emarket.domain.Product;

@Local
public interface OrderItemDAO extends Serializable{

	OrderItem addNewOrderItem(OrderItem orderItem);

}
