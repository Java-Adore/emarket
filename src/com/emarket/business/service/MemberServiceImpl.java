package com.emarket.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.emarket.dao.UserDAO;
import com.emarket.domain.User;
import com.emarket.general.Constants;
import com.emarket.general.EMarketException;

@Stateless
public class MemberServiceImpl implements MemberService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	UserDAO userDAO;

	
	public User addUser(User user) throws EMarketException {
		try {
			if (getUserByUserName(user.getUserName()) == null) {
				return userDAO.addUser(user);
			} else {
				throw Constants.EMAIL_ALREADY_EXISTS;

			}
		} catch (EMarketException ex) {
			throw ex;
		} catch (Exception ex) {
			throw Constants.DATABASE_ERROR;

		}
	}

	
	public List<User> getAllUsers() {
		return null;
	}

	
	public User getUserByID(Long l) {
		return null;
	}

	@Override
	public  User getUserByUserName(String userName) {
		return userDAO.getUserByUserName(userName);
	}

	
 
	

}
