package com.emarket.business.facade;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.Flower;
import com.emarket.domain.Honey;
import com.emarket.domain.Miscellaneous;
import com.emarket.domain.Product;
import com.emarket.domain.User;
import com.emarket.domain.Wax;
import com.emarket.general.EMarketException;


@Local
public interface EmarketFacade  {
	

	List<User> getAllUsers();

	User getUserByID(Long l);
	
	User login(String userName , String password)throws EMarketException ;
	
	User register(String firstName, String lastName, String userName, String password, String confirmPassword, String pictureURL) throws EMarketException ;

	List<Flower> getAllFlowersProducts();

	Flower addNewFlowerProduct(Flower product);

	List<Wax> getAllWaxProducts();

	Wax addNewWaxProduct(Wax product);

	List<Miscellaneous> getAllMiscellaneousProducts();

	Miscellaneous addNewProduct(Miscellaneous product);

	List<Honey> getAllHoneyProducts();

	Honey addNewHoneyProduct(Honey product);

	

	
}