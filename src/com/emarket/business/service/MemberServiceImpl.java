package com.emarket.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.emarket.dao.MemberDAO;
import com.emarket.entity.Member;
import com.emarket.general.Constants;
import com.emarket.general.EMarketException;

@Stateless
public class MemberServiceImpl implements MemberService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	MemberDAO memberDAO;

	
	public Member addMember(Member member) throws EMarketException {
		try {
			if (getMemeberByEmail(member.getEmail()) == null) {
				return memberDAO.addMember(member);
			} else {
				throw Constants.EMAIL_ALREADY_EXISTS;

			}
		} catch (EMarketException ex) {
			throw ex;
		} catch (Exception ex) {
			throw Constants.DATABASE_ERROR;

		}
	}

	
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Member getMemberByID(Long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  Member getMemeberByEmail(String email) {
		return memberDAO.getMemeberByEmail(email);
	}

	
 
	

}
