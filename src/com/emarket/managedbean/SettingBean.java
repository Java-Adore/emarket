package com.emarket.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.emarket.business.facade.EmarketFacade;
import com.emarket.domain.User;
import com.emarket.general.Constants;
import com.emarket.general.EMarketException;
import com.emarket.utils.Util;
import com.emarket.utils.WebUtils;

@ManagedBean
@ViewScoped
public class SettingBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@EJB
	EmarketFacade memberFacade;
	private User user;
	private String firstName;
	private String lastName;
	private String userName;
	private String oldPassword;
	private String newPassword;
	private String confirmPass;

	@PostConstruct
	public void loadAccountSetting() {
		
		initAccount(memberFacade.getUserByID(((User) WebUtils
				.extractFromSession(Constants.CURRENT_LOGGED_USER)).getID()));

	}

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

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void edit() {
		User oldUser = memberFacade.getUserByID(user.getID());
		String encryptedOldPass = Util.encrypt(oldPassword);
		boolean flag=false;
		if (encryptedOldPass.equals(oldUser.getPassword())) {
			
			User newUser = new User();
			newUser.setID(oldUser.getID());
			newUser.setFirstName(firstName);
			newUser.setLastName(lastName);
			newUser.setUserName(userName);
			
			if (newPassword.equals("") && confirmPass.equals("")) {			
				newUser.setPassword(encryptedOldPass);
				flag=true;
			} else {
				if(Util.encrypt(newPassword).equals(Util.encrypt(confirmPass))){
					newUser.setPassword(Util.encrypt(newPassword));
					flag=true;
				}else{
					WebUtils.fireErrorMessage(Constants.REGISTRATION_PASSWORD_AND_CONFIRMATION_SHOULD_BE_MATCHED);
				}
			}
			
			if(flag==true){
				memberFacade.updateUserByID(newUser);
				initAccount(newUser);
				WebUtils.injectIntoSession(Constants.CURRENT_LOGGED_USER, newUser);
				this.oldPassword=newPassword;
				WebUtils.fireErrorMessage("UPDATED_SUCCESSFULLY");
			}
			
		} else {
			WebUtils.fireErrorMessage("WRONG_OLD_PASSWORD");
		}

	}

	private void validatePasswords() throws EMarketException {

		if (!newPassword.equals(confirmPass)) {
			throw new EMarketException(
					Constants.REGISTRATION_PASSWORD_AND_CONFIRMATION_SHOULD_BE_MATCHED);
		}

	}
	
	private void initAccount(User user){
		this.user = user;
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.userName = user.getUserName();
		this.newPassword = "";
		this.confirmPass = "";
	}

}
