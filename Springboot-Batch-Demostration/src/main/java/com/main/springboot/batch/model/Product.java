/**
 * Code developed by Ashfaq (© [Year])
 * GitHub: https://github.com/DarkSharkAsh
 */



package com.main.springboot.batch.model;

public class Product {

	
	private int productId;
	private String title;
	private String description;
	private String price;
	private String discount;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int productId, String title, String description, String price, String discount) {
		this.productId = productId;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discount = discount;
	}
	
	
	
 }
