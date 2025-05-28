package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class OrderDetail {
	private int orderId;
	private String productName;
	private double unitPrice;
	private int qty;
	private double total;
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
		this.total = this.unitPrice * this.qty;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
		this.total = this.unitPrice * this.qty;
	}
	public double getTotal() {
		return total;
	}
	
	

}
