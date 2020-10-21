package com.google.play.entity;

public class Bill {
	
	private int numMovie;
	private double netPrice;
	private double numBill;
	
	
	
	
	public Bill() {
		super();
	}
	public Bill(int numMovie, double netPrice, double numBill) {
		super();
		this.numMovie = numMovie;
		this.netPrice = netPrice;
		this.numBill = numBill;
	}
	public double getNumBill() {
		return numBill;
	}
	public void setNumBill(double numBill) {
		this.numBill = numBill;
	}
	public int getNumMovie() {
		return numMovie;
	}
	public void setNumMovie(int numMovie) {
		this.numMovie = numMovie;
	}
	public double getNetPrice() {
		return netPrice;
	}
	public void setNetPrice(double netPrice) {
		this.netPrice = netPrice;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(numBill);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Bill other = (Bill) obj;
		if (Double.doubleToLongBits(numBill) != Double.doubleToLongBits(other.numBill))
			return false;
		return true;
	}
	
	

}
