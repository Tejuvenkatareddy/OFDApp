package com.capgemini.OFDApp.exceptions;

public class ItemIdExceptionResponse {
	private String ItemId;

	public ItemIdExceptionResponse(String itemId) {
		super();
		this.ItemId = itemId;
	}

	public String getItemId() {
		return ItemId;
	}

	public void setItemId(String itemId) {
		this.ItemId = itemId;
	}
}
