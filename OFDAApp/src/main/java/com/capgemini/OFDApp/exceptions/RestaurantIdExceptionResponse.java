package com.capgemini.OFDApp.exceptions;

public class RestaurantIdExceptionResponse {


	private String restaurantId;

	public RestaurantIdExceptionResponse(String restaurantId) {
		super();
		this.restaurantId = restaurantId;
	}

	public String getRestaurantId() {
		return restaurantId;
	}

	public void setrestaurantId(String resId) {
		this.restaurantId = resId;
	}
}
