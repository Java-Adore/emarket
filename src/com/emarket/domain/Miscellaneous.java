package com.emarket.domain;

import java.util.Date;

public class Miscellaneous extends Product {
	private Date expireDate;
	private String areaOfApplication;
	
	public Miscellaneous(String name, String description, Date expiryDate, String areaOfApplication, double price) {
		super(name, description, price);
		this.expireDate = expireDate;
		this.areaOfApplication = areaOfApplication;
	}

	public Date getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(Date expireDate) {
		this.expireDate = expireDate;
	}

	public String getAreaOfApplication() {
		return areaOfApplication;
	}

	public void setAreaOfApplication(String areaOfApplication) {
		this.areaOfApplication = areaOfApplication;
	}
	
	@Override
	public String toString(){
		return "Other bee product: " + getName() + ", best before " + expireDate + ", " + getDescription() + ", " + areaOfApplication;
	}
}
