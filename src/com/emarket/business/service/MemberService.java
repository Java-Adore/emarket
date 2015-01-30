package com.emarket.business.service;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.entity.Member;
import com.emarket.general.EMarketException;

@Local
public interface MemberService extends Serializable{

	/**
	 * 
	 */
	
	Member addMember(Member Member) throws EMarketException;

	List<Member> getAllMembers();

	Member getMemberByID(Long l);
	
	public Member getMemeberByEmail(String email);
	


	}
