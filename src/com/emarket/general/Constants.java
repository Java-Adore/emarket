package com.emarket.general;

import java.io.Serializable;

import javax.faces.convert.ConverterException;



public class Constants implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public static final int ACTIVE = 1;
	public static final String HOME_PAGE = "allProducts.xhtml"; 
	public static final String USER_ADDED_SUCCESSFULLY = "USER_ADDED_SUCCESSFULLY";
	public static final String REGISTRATION_PASSWORD_AND_CONFIRMATION_SHOULD_BE_MATCHED = "REGISTRATION_PASSWORD_AND_CONFIRMATION_SHOULD_BE_MATCHED";
	public static final ConverterException CONVERSION_EXCEPTION = new ConverterException();
	public static final String LOGOUT = "LOGOUT";
	public static final String LOGIN_PAGE = "login.xhtml";
	public static final Exception EXCEPTION = new Exception();
	public static final String CURRENT_LOGGED_USER = "CURRENT_LOGGED_USER";
	public static final RuntimeException RUNTIME_EXCEPTION = new RuntimeException();
	public static final String EMAIL_ALREADY_EXIST = "EMAIL_ALREADY_EXIST";
	public static final EMarketException EMAIL_ALREADY_EXISTS = new EMarketException(
			EMAIL_ALREADY_EXIST);
	public static final String DATABASE_ERROR_MESSAGE = "DATABASE_ERROR";
	public static final EMarketException DATABASE_ERROR = new EMarketException(
			DATABASE_ERROR_MESSAGE);
	public static final String MEMBER_INVALID_EMAIL = "MEMBER_INVALID_EMAIL";
	public static final String MEMBER_INVALID_PASSOWRD = "MEMBER_INVALID_PASSOWRD";
	public static final EMarketException invalidEmail = new EMarketException(
			MEMBER_INVALID_EMAIL);
	public static final EMarketException invalidPassword = new EMarketException(
			MEMBER_INVALID_PASSOWRD);
	public static final String CURRENT_SHOPING_CART = "currentShoppingCart";

	
}
