package org.java.expizza.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@Column(columnDefinition="TEXT")
	private String description;
	
	private String picture;
	
	private float price;

	public Pizza() {}

	public Pizza(String name, String description, String picture, float price) {
		setName(name);
		setDescription(description);
		setPicture(picture);
		setPrice(price);
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

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

	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	} 
	
	@Override
	public String toString() {
		return "[" + getId() + "] " + getName()
				+ "\nDescription: " + getDescription()
				+ "\nPicture: " + getPicture()
				+ "\nPrice: €" + getPrice();
	}
	
}
