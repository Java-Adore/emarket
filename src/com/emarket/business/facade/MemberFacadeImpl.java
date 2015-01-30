package com.emarket.business.facade;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.emarket.business.service.MemberService;
import com.emarket.entity.Member;
import com.emarket.general.Constants;
import com.emarket.general.EMarketException;
import com.emarket.utils.Util;

@Stateless
public class MemberFacadeImpl implements MemberFacade {

	@EJB
	private MemberService memberService;


	

	@Override
	public List<Member> getAllMembers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Member getMemberByID(Long l) {
		// TODO Auto-generated method stub
		return null;
	}


	public Member login(String email, String password) throws EMarketException {

		Member member = memberService.getMemeberByEmail(email);
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
	public Member register(String firstName, String lastName, String email,
			String password, String confirmPassword, String userPicPath)
			throws EMarketException {
	
		
		Member member = new Member();
		member.setEmail(email);
		member.setFirstName(firstName);
		member.setLastName(lastName);
		member.setUserPicPath(userPicPath);
		member.setPassword(com.emarket.utils.Util.encrypt(password));
		member = memberService.addMember(member);
		return member;

	}
}
