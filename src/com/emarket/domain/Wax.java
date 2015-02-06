package com.emarket.domain;

import javax.persistence.Entity;

@Entity
public class Wax extends Product {

	public Wax(){}
	
	public Wax(String name, String description, double price) {
		super(name, description, price);
	}
	
	@Override
	public String toString(){
		return "Wax product: " + getName() + "," + getDescription();
	}
}
