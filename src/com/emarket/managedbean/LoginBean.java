package com.emarket.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.emarket.utils.WebUtils;
import com.emarket.business.facade.EmarketFacade;
import com.emarket.domain.User;
import com.emarket.general.Constants;
import com.emarket.general.EMarketException;

@ManagedBean
@ViewScoped
public class LoginBean implements Serializable {


	@EJB
	EmarketFacade memberFacade;

	private static final long serialVersionUID = 1L;

	private String userName;
	private String password;

	@PostConstruct
	public void init() {

	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void login() {
		try {
			System.out
					.println("===========================\n\n\n========================");
			User member = memberFacade.login(userName, password);

			WebUtils.fireInfoMessage(WebUtils.perpareWelcomeMessage(member
					.getFirstName()));

			WebUtils.injectIntoSession(Constants.CURRENT_LOGGED_USER, member);
			if (member.getRole().intValue() == 0) {
				WebUtils.redirectTo(Constants.HOME_PAGE);
			} else if (member.getRole().intValue() == 1) {
				WebUtils.redirectTo("manageproducts.xhtml"); 

			}

		} catch (EMarketException e) {
			WebUtils.fireErrorMessage(e.getMessageKey());
		}

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
