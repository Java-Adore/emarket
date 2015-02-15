package com.emarket.business.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.Flower;
import com.emarket.domain.Honey;
import com.emarket.domain.Miscellaneous;
import com.emarket.domain.OrderItem;
import com.emarket.domain.Product;
import com.emarket.domain.Wax;

@Local
public interface OrderItemService extends Serializable {

	OrderItem addNewOrderItem(OrderItem orderItem);

}
