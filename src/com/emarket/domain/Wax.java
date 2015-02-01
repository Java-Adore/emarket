package com.emarket.domain;

public class Wax extends Product {

	public Wax(String name, String description, double price) {
		super(name, description, price);
	}
	
	@Override
	public String toString(){
		return "Wax product: " + getName() + "," + getDescription();
	}
}
