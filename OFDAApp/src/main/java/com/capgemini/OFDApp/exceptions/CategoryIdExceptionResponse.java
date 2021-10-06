package com.capgemini.OFDApp.exceptions;

public class CategoryIdExceptionResponse {


	private String categoryId;

	public CategoryIdExceptionResponse(String categoryId) {
		super();
		this.categoryId = categoryId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setrestaurantId(String categoryId) {
		this.categoryId = categoryId;
	}
}
