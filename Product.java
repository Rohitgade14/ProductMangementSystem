package com.jsp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	int id;
	String brand;
	int warrenty;
	double price;
	
	public Product(int id, String brand, int warrenty, double price) {
		super();
		this.id = id;
		this.brand = brand;
		this.warrenty = warrenty;
		this.price = price;
	}
	
	public Product() {
		super();
	
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getWarrenty() {
		return warrenty;
	}

	public void setWarrenty(int warrenty) {
		this.warrenty = warrenty;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", brand=" + brand + ", warrenty=" + warrenty + ", price=" + price + "]";
	}
	
	
	

}
