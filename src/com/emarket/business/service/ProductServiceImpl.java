package com.emarket.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.emarket.dao.FlowerDAO;
import com.emarket.dao.HoneyDAO;
import com.emarket.dao.MiscellaneousDAO;
import com.emarket.dao.UserDAO;
import com.emarket.dao.WaxDAO;
import com.emarket.domain.Flower;
import com.emarket.domain.Honey;
import com.emarket.domain.Miscellaneous;
import com.emarket.domain.OrderItem;
import com.emarket.domain.Product;
import com.emarket.domain.Wax;

@Stateless
public class ProductServiceImpl implements ProductService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	HoneyDAO honeyDAO;
	
	@EJB
	FlowerDAO flowerDAO;
	
	@EJB
	MiscellaneousDAO miscellaneousDAO;
	
	@EJB
	WaxDAO waxDAO;
	
	

	@Override
	public List<Flower> getAllFlowersProducts() {
		
		return flowerDAO.getAllProducts();
	}

	@Override
	public Flower addNewFlowerProduct(Flower product) {
		
		return flowerDAO.addNewProduct(product);
	}

	@Override
	public List<Wax> getAllWaxProducts() {
		
		return waxDAO.getAllProducts();
	}

	@Override
	public Wax addNewWaxProduct(Wax product) {
		
		return waxDAO.addNewProduct(product);
	}

	@Override
	public List<Miscellaneous> getAllMiscellaneousProducts() {
		
		return miscellaneousDAO.getAllProducts();
	}

	@Override
	public Miscellaneous addNewProduct(Miscellaneous product) {
		
		return miscellaneousDAO.addNewProduct(product);
	}

	@Override
	public List<Honey> getAllHoneyProducts() {
		
		return honeyDAO.getAllProducts();
	}

	@Override
	public Honey addNewHoneyProduct(Honey product) {
		
		return honeyDAO.addNewProduct(product);
	}


	@Override
	public Product getProduct(Product product) {
		// TODO Auto-generated method stub
		Product pro = null;
		if(product.getProductType().equals("Honey")){
			pro=honeyDAO.getProductById(product.getID());
		} else if(product.getProductType().equals("Wax")){
			pro=waxDAO.getProductById(product.getID());
		} else if(product.getProductType().equals("Miscellaneous")){
			pro=miscellaneousDAO.getProductById(product.getID());
		}
			
		return pro;
	}

	@Override
	public void updateproductAmount(Product product, Integer newAmount) {
		
		Product pro=null;
		Integer updatedAmount=0;
		if(product.getProductType().equals("Honey")){
			pro=honeyDAO.getProductById(product.getID());
			updatedAmount = pro.getAmount() - newAmount;
			product.setAmount(updatedAmount);
			honeyDAO.updateProduct((Honey)product);
			
		} else if(product.getProductType().equals("Wax")){
			pro=waxDAO.getProductById(product.getID());
			updatedAmount = pro.getAmount() - newAmount;
			product.setAmount(updatedAmount);
			waxDAO.updateProduct((Wax)product);
			
		} else if(product.getProductType().equals("Miscellaneous")){
			pro=miscellaneousDAO.getProductById(product.getID());
			updatedAmount = pro.getAmount() - newAmount;
			product.setAmount(updatedAmount);
			miscellaneousDAO.updateProduct((Miscellaneous)product);
		}
					
	}

	

}
