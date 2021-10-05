package com.capgemini.OFDApp.exceptions;

public class CategoryIdExceptionResponse {


	private String categoryId;

	public CategoryIdExceptionResponse(String restaurantId) {
		super();
		this.categoryId = categoryId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setrestaurantId(String resId) {
		this.categoryId = categoryId;
	}
}
