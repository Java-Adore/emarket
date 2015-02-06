package com.emarket.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Honey extends Product {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date expiryDate;
	
	@ManyToOne
	@JoinColumn(name="flower_source" , referencedColumnName="id")
	private Flower source;
	
	public Honey(){} 
	public Honey(String name, String description, Date expiryDate, Flower source, double price) {
		super(name, description, price);
		this.expiryDate = expiryDate;
		this.source = source;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public Flower getSource() {
		return source;
	}

	public void setSource(Flower source) {
		this.source = source;
	}
	@Override
	public String toString(){
		return "Honey: " + source.getName() + ", best before " + expiryDate + ", " + getDescription();
	}
}
