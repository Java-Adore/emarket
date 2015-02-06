package com.emarket.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;

import com.emarket.domain.Flower;
import com.emarket.domain.Honey;
import com.emarket.domain.Product;

@Singleton
public class FlowerDAOImpl extends AbstractDAO<Flower>implements FlowerDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public FlowerDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public Flower addNewProduct(Flower product) {
		return super.persist(product);
	}

	@Override
	public List<Flower> getAllProducts() {
		return super.findAll(Flower.class);
	}

}
