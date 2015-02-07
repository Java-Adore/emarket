package com.emarket.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.Miscellaneous;
import com.emarket.domain.Wax;

@Local
public interface WaxDAO extends Serializable{

	Wax addNewProduct(Wax product);

	List<Wax> getAllProducts();

	Wax getProductById(Long id);

	

}
