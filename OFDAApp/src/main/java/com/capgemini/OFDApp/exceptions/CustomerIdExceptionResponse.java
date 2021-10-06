package com.capgemini.OFDApp.exceptions;

public class CustomerIdExceptionResponse {


	private String customerId;

	public CustomerIdExceptionResponse(String customerId) {
		super();
		this.customerId = customerId;
	}

	public String getOrderId() {
		return customerId;
	}

	public void setCustomerId(String CustomerId) {
		this.customerId = CustomerId;
	}
}