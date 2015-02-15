package com.emarket.business.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.emarket.dao.OrderItemDAO;
import com.emarket.domain.OrderItem;

@Stateless
public class OrderItemServiceImpl implements OrderItemService {

	
	private static final long serialVersionUID = 1L;
	
	@EJB
	OrderItemDAO orderItemDAO;

	@Override
	public OrderItem addNewOrderItem(OrderItem orderItem) {
		
		return orderItemDAO.addNewOrderItem(orderItem);
	}
}
