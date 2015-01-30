package com.emarket.business.facade;

import java.util.List;

import javax.ejb.Local;

import com.emarket.entity.Member;
import com.emarket.general.EMarketException;


@Local
public interface MemberFacade  {
	

	List<Member> getAllMembers();

	Member getMemberByID(Long l);
	
	Member login(String email , String password)throws EMarketException ;
	
	Member register(String firstName, String lastName, String email, String password, String confirmPassword, String pictureURL) throws EMarketException ;
	

	
}
