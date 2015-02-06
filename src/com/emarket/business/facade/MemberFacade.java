package com.emarket.business.facade;
import com.emarket.domain.*;
import java.util.List;

import javax.ejb.Local;

import com.emarket.general.EMarketException;


@Local
public interface MemberFacade  {
	

	List<User> getAllUsers();

	User getUserByID(Long l);
	
	User login(String userName , String password)throws EMarketException ;
	
	User register(String firstName, String lastName, String userName, String password, String confirmPassword, String pictureURL) throws EMarketException ;
	

	
}
