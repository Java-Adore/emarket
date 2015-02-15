package com.emarket.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;

import com.emarket.domain.*;

@Singleton
public class MiscellaneousDAOImpl extends AbstractDAO<Miscellaneous>implements MiscellaneousDAO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	EntityManager entityManager = getEntityManagerFactory()
			.createEntityManager();

	public MiscellaneousDAOImpl() {
		super.setEntityManager(entityManager);
	}

	@Override
	public Miscellaneous addNewProduct(Miscellaneous product) {
		return super.persist(product);
	}

	@Override
	public List<Miscellaneous> getAllProducts() {
		return super.findAll(Miscellaneous.class);
	}

	@Override
	public Miscellaneous getProductById(Long id) {
		return super.getEntityByID(Miscellaneous.class,id);
	}

	@Override
	public void updateProduct(Miscellaneous product) {
		super.addOrUpdate(product);
		
	}
}
