package com.emarket.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.Flower;
import com.emarket.domain.Honey;
import com.emarket.domain.Product;

@Local
public interface FlowerDAO extends Serializable{

	Flower addNewProduct(Flower product);

	List<Flower> getAllProducts();

	

}
