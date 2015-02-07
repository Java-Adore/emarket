package com.emarket.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;

import com.emarket.domain.Honey;
import com.emarket.domain.Order;
import com.emarket.domain.OrderItem;
import com.emarket.domain.Product;

@Singleton
public class OrderDAOImpl extends AbstractDAO<Order>implements OrderDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public OrderDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public Order addNewOrder(Order order) {
		return super.persist(order);
	}

	@Override
	public void addNewOrderItem(OrderItem orderItem) {
		super.addOrUpdate(orderItem);
		
	}

	

}
