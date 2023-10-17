package com.narendra.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//@Data
@Entity
@Table
public class BookEntity {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String describpion;
	private String author;
	private double price;
	
	public BookEntity() {
		super();
	}

	public BookEntity(int id, String name, String describpion, String author, double price) {
		super();
		this.id = id;
		this.name = name;
		this.describpion = describpion;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescribpion() {
		return describpion;
	}

	public void setDescribpion(String describpion) {
		this.describpion = describpion;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "BookEntity [id=" + id + ", name=" + name + ", describpion=" + describpion + ", author=" + author
				+ ", price=" + price + "]";
	}
	
}
