package com.google.play.entity;

public class Movie {
	
	private String name;
	private Integer stock;
	

	public Movie() {
		super();
	}


	public Movie(String name, Integer stock) {
		super();
		this.name = name;
		this.stock = stock;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}

	
}
