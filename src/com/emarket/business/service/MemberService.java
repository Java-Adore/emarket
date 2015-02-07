package com.emarket.business.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.domain.User;
import com.emarket.general.EMarketException;

@Local
public interface MemberService extends Serializable{

	/**
	 * 
	 */
	
	User addUser(User user) throws EMarketException;

	List<User> getAllUsers();

	User getUserByID(Long l);
	
	public User getUserByUserName(String username);

	void updateUserByID(User user);
	


	}
