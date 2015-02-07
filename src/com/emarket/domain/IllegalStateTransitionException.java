package com.emarket.domain;

import java.util.List;

public class IllegalStateTransitionException extends Exception {
	private static final long serialVersionUID = 1L;

	
	
	private List<Object> object;
	

	
	
	
	public IllegalStateTransitionException(String from, String to, String reason) {
		super("Illegal State transition: going from " + from + " to " + to + " is not allowed because " + reason + ".");
	}
	public IllegalStateTransitionException(){}
	public List<Object> getObject() {
		return object;
	}
	public void setObject(List<Object> object) {
		this.object = object;
	}
}
