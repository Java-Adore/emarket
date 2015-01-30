package com.emarket.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Local;

import com.emarket.entity.Member;

@Local
public interface MemberDAO extends Serializable{

	/**
	 * 
	 */
	
	Member addMember(Member Member);

	List<Member> getAllMembers();

	Member getMemberByID(Long l);

	Member getMemeberByEmail(String email);
	
	

}
