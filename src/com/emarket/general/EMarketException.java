package com.emarket.general;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class EMarketException extends Exception  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String messageKey;
	private Map feedBack = new HashMap();
	
	public EMarketException(String messageKey) {
		this.messageKey = messageKey;
	}

	public EMarketException() {
		
	}

	public String getMessageKey() {
		return messageKey;
	}

	public EMarketException setMessageKey(String messageKey) {
		this.messageKey = messageKey;
		return this;
	}

	public Map getFeedBack() {
		return feedBack;
	}

	public void setFeedBack(Map feedBack) {
		this.feedBack = feedBack;
	}

	
	
}
