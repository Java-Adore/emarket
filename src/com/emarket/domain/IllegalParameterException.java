package com.emarket.domain;

public class IllegalParameterException extends Exception {
	private static final long serialVersionUID = 1L;

	public IllegalParameterException(String message) {
		super(message);
	}
}
