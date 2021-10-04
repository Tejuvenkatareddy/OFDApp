package com.capgemini.OFDApp.exceptions;

/**
 * 
 * @author Sreeraj R
 *
 */
public class CartIdExceptionResponse {

	private String cartId;

	public CartIdExceptionResponse(String cartId) {
		super();
		this.cartId = cartId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
}
