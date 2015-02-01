package com.emarket.domain;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Special class for output in theShoppingCartBean; do not store in database
// In the database, ShoppingCarts with status COMPLETED are stored.
public class OrderItem implements Comparable<OrderItem> , Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long id;
	private String name;
	
	private Double price;
	
	private Integer amount;
	
	public OrderItem() {
		
	}

	public OrderItem(Long id, String name, double price, int amount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	@Override
	public int compareTo(OrderItem other) {
		return this.name.compareTo(other.name);
	}
}
