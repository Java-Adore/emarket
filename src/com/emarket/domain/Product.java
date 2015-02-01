package com.emarket.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy =InheritanceType.JOINED)
public abstract class Product implements Comparable<Product> {
	private static long currentId =1;
	@Id @GeneratedValue
	private Long id;
	private String name;
	private String description;
	private Double price; // in euro, internationalization can come later
	
	@Column(name="product_Type")
	protected String productType;
	public Product(){}
	public Product(String name, String description, double price) {
		super();
		this.id = currentId++; // Simple way of getting an unique id. To be deferred to the DBMS later.
		this.name = name;
		this.description = description;
		this.price = price;
		if (this instanceof Honey) {
			productType = "Honey";
		}
		else if (this instanceof Wax) {
			productType = "Wax";
		}
		else if (this instanceof Miscellaneous) {
			productType = "Miscellaneous";
		}
		else {
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
	public Long getId() {
		return id;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public void setId(Long id) {
		this.id = id;
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
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
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
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public final int compareTo(Product other) {
		if (this.getClass().toString().compareTo(other.getClass().toString()) == 0) {
			return this.name.compareTo(other.name);
		}
		else {
			return this.getClass().toString().compareTo(other.getClass().toString());
		}
	}
}
