package com.capgemini.OFDApp.exceptions;

/**
 * The OrderIdExceptionResoonse class is the response class of OrderIdException
 * @author Sreeraj R
 */
public class OrderIdExceptionResponse {
	private String orderId;

	public OrderIdExceptionResponse(String orderId) {
		super();
		this.orderId = orderId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
