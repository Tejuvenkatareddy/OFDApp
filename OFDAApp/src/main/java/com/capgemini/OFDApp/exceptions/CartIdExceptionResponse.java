package com.capgemini.OFDApp.exceptions;

/**
 * The CartIdExceptionResoonse class is the response class of CartIdException
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
