package com.emarket.managedbean;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.emarket.business.facade.EmarketFacade;
import com.emarket.domain.User;
import com.emarket.general.Constants;
import com.emarket.general.EMarketException;
import com.emarket.utils.WebUtils;
@ManagedBean
@ViewScoped
public class RegisterationBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	EmarketFacade memberFacade;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String confirmPass;
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}



	public void register() {

		try {
			validatePasswords();
			User user = memberFacade.register(firstName, lastName, userName, password,
					confirmPass, null);
			WebUtils.fireInfoMessage(Constants.USER_ADDED_SUCCESSFULLY);
			WebUtils.injectIntoSession(Constants.CURRENT_LOGGED_USER, user);
			WebUtils.redirectTo(Constants.HOME_PAGE);

		} catch (EMarketException e) {

			WebUtils.fireErrorMessage(e.getMessageKey());
		}

	}

	

	private void validatePasswords() throws EMarketException {

		if (!password.equals(confirmPass)) {
			throw new EMarketException(
					Constants.REGISTRATION_PASSWORD_AND_CONFIRMATION_SHOULD_BE_MATCHED);
		}

	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
