package com.emarket.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;

import com.emarket.domain.*;

@Singleton
public class WaxDAOImpl extends AbstractDAO<Wax>implements WaxDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public WaxDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public Wax addNewProduct(Wax product) {
		return super.persist(product);
	}

	@Override
	public List<Wax> getAllProducts() {
		return super.findAll(Wax.class);
	}

	@Override
	public Wax getProductById(Long id) {
		return super.getEntityByID(Wax.class,id);
	}

}
