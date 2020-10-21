package com.google.play.entity;

public class Movie {
	
	private String name;
	private Integer stock;
	private Double netPrice;
	

	public Movie() {
		super();
	}

	public Movie(String name, Integer stock, Double netPrice) {
		super();
		this.name = name;
		this.stock = stock;
		this.netPrice = netPrice;
	}
	
	public Movie(String name, Integer stock) {
		super();
		this.name = name;
		this.stock = stock;
		this.netPrice = 0.0;
	}

	public Double getNetPrice() {
		return netPrice;
	}


	public void setNetPrice(Double netPrice) {
		this.netPrice = netPrice;
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
		Movie other = (Movie) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
