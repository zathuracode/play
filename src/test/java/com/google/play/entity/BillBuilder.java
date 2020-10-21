package com.google.play.entity;

public class BillBuilder {
	
	private static BillBuilder billBuilder;
	
	private Bill bill;
	
	private BillBuilder() {}

	public static BillBuilder getBill() {
		billBuilder=new BillBuilder();
		billBuilder.bill=new Bill();
		billBuilder.bill.setNetPrice(10.0);
		billBuilder.bill.setNumMovie(10);
		billBuilder.bill.setNumBill(909090);
		
		return billBuilder;
	}
	
	public BillBuilder otherNumBill(Double numBill) {
		bill.setNumBill(numBill);
		return this;
	}
	
	public Bill now() {
		return bill;
	}
}
