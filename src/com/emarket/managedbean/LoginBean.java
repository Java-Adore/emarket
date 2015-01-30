package com.emarket.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.emarket.utils.Util;
import com.emarket.utils.WebUtils;
import com.emarket.business.facade.MemberFacade;
import com.emarket.entity.Member;
import com.emarket.general.Constants;
import com.emarket.general.EMarketException;



@ManagedBean
@ViewScoped
public class LoginBean implements Serializable{

	/**
	 * 
	 */
	// Construct alert thread bean 

	@EJB 
	MemberFacade memberFacade;
	
	private static final long serialVersionUID = 1L;
	
	private String email;
	private String password;
	
	@PostConstruct
	public void init(){
		
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void login(){
		try {
			System.out.println("===========================\n\n\n========================");
			Member member = 	memberFacade.login(email , password);
			WebUtils.fireInfoMessage( WebUtils.perpareWelcomeMessage(member.getFirstName()) );
			
			WebUtils.injectIntoSession( Constants.CURRENT_LOGGED_USER , member );
				
			WebUtils.redirectTo(Constants.HOME_PAGE);
			
		} catch (EMarketException e) {
			WebUtils.fireErrorMessage(e.getMessageKey());
		}
		
	}
}
