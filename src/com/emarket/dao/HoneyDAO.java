package com.emarket.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.Honey;
import com.emarket.domain.Product;

@Local
public interface HoneyDAO extends Serializable{

	Honey addNewProduct(Honey product);

	List<Honey> getAllProducts();
	
	Honey getProductById(Long id);
	
	void updateProduct(Honey product);

}
