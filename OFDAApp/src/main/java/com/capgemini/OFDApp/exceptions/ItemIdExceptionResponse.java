package com.capgemini.OFDApp.exceptions;

public class ItemIdExceptionResponse {
	private String ItemId;

	public ItemIdExceptionResponse(String itemId) {
		super();
		this.ItemId = itemId;
	}

	public String getCartId() {
		return ItemId;
	}

	public void setCartId(String itemId) {
		this.ItemId = itemId;
	}
}
