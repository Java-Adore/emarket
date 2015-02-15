package com.emarket.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;

import com.emarket.domain.Honey;
import com.emarket.domain.Miscellaneous;
import com.emarket.domain.Product;

@Singleton
public class HonyDAOImpl extends AbstractDAO<Honey>implements HoneyDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public HonyDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public Honey addNewProduct(Honey product) {
		return super.persist(product);
	}

	@Override
	public List<Honey> getAllProducts() {
		return super.findAll(Honey.class);
	}
	
	@Override
	public Honey getProductById(Long id) {
		return super.getEntityByID(Honey.class,id);
	}

	@Override
	public void updateProduct(Honey product) {
		// TODO Auto-generated method stub
		super.addOrUpdate(product);
	}

}
