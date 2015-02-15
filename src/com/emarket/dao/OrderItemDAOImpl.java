package com.emarket.dao;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;

import com.emarket.domain.OrderItem;

@Singleton
public class OrderItemDAOImpl extends AbstractDAO<OrderItem>implements OrderItemDAO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public OrderItemDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public OrderItem addNewOrderItem(OrderItem orderItem) {
		
		return super.persist(orderItem);
	}

}
