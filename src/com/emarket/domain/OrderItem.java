package com.emarket.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.emarket.general.Marker;


// Special class for output in theShoppingCartBean; do not store in database
// In the database, ShoppingCarts with status COMPLETED are stored.
@Entity
public class OrderItem implements Comparable<OrderItem> , Serializable, Marker{
	
	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue
	private Long ID;
	
	private String name;
	
	private Double price;
	
	private Integer amount;
	
	
	public OrderItem() {
		
	}
	public OrderItem(String name, Double price, Integer amount, Product product) {
		
	}
	
	@Override
	public Long getID() {
		
		return ID;
	}
	
	@Override
	public void setID(Long ID) {
		this.ID = ID;
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
