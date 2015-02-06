package com.emarket.business.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.emarket.business.service.MemberService;
import com.emarket.domain.User;
import com.emarket.general.Constants;
import com.emarket.general.EMarketException;
import com.emarket.utils.Util;

@Stateless
public class MemberFacadeImpl implements MemberFacade {

	@EJB
	private MemberService memberService;

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByID(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	public User login(String userName, String password) throws EMarketException {

		User member = memberService.getUserByUserName(userName);
		if (member == null) {
			throw Constants.invalidEmail;
		} else {
			if (member.getPassword() != null
					&& member.getPassword().equals(Util.encrypt(password))) {
				return member;

			} else {
				throw Constants.invalidPassword;
			}
		}
	}

	@Override
	public User register(String firstName, String lastName, String userName,
			String password, String confirmPassword, String userPicPath)
			throws EMarketException {

		User user = new User();
		user.setUserName(userName);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setPassword(com.emarket.utils.Util.encrypt(password));
		user.setRole(0);
		user = memberService.addUser(user);
		return user;

	}
}
