package com.emarket.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.Honey;
import com.emarket.domain.Miscellaneous;
import com.emarket.domain.Product;

@Local
public interface MiscellaneousDAO extends Serializable{

	Miscellaneous addNewProduct(Miscellaneous product);

	List<Miscellaneous> getAllProducts();

	Miscellaneous getProductById(Long id);

}
