package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	private int orderId;
	private String orderDate;
	
	private List<OrderDetail> orderDetails = new ArrayList<>();
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
	
}
