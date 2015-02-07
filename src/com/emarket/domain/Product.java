package com.emarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import com.emarket.general.Marker;
 
@MappedSuperclass 
public abstract class Product implements Comparable<Product>, Marker , Editable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long ID;
	private String name;
	private String description;
	@Column(nullable=false)
	private double price; 
	@Column(nullable = false)
	private int amount;

	@Column(name = "product_Type")
	protected String productType;
	
	
	private  boolean editMode;
	

	public Product() {
	}

	public Product(String name, String description, double price) {
		super();
		// this.id = currentId++; // Simple way of getting an unique id. To be
		// deferred to the DBMS later.
		this.name = name;
		this.description = description;
		this.price = price;
		if (this instanceof Honey) {
			productType = "Honey";
		} else if (this instanceof Wax) {
			productType = "Wax";
		} else if (this instanceof Miscellaneous) {
			productType = "Miscellaneous";
		} else {
			productType = "Unknown";
		}
	}

	public abstract String toString();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return productType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		return result;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setPrice(Double price) {
		this.price = price;
	}


	@Override
	public final int compareTo(Product other) {
		if (this.getClass().toString().compareTo(other.getClass().toString()) == 0) {
			return this.name.compareTo(other.name);
		} else {
			return this.getClass().toString()
					.compareTo(other.getClass().toString());
		}
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public boolean isEditMode() {
		return editMode;
	}

	public void setEditMode(boolean editMode) {
		this.editMode = editMode;
	} 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		return true;
	}
}
