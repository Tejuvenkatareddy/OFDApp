package com.capgemini.OFDApp.exceptions;

public class OrderIdExceptionResponse {


	private String orderId;

	public OrderIdExceptionResponse(String orderId) {
		super();
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String cartId) {
		this.orderId = cartId;
	}
}
