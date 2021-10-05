package com.capgemini.OFDApp.service;

import com.capgemini.OFDApp.domain.*;

/**
 * The IFoodCartService interface is a service, which is used to implement the business Logic of cart
 * @author Sreeraj R
 *
 */
public interface IFoodCartService {
	
	public FoodCart createCart(FoodCart cart,Integer customerId);
	
	/**
	 * This addItemToCart method will add the item to cart
	 * @param cart
	 * @param item
	 * @return 
	 */
	public FoodCart addItemToCart(int cartId, int itemId);
	
	/**
	 * This increaseQuantity method will increase the quantity of item by the value of quantity in the cart
	 * @param cart
	 * @param item
	 * @param quantiy
	 * @return
	 */
	public FoodCart increaseQuantity(int cart_id,int item_id, int quantity);
	/**
	 * This reduceQuantity method will reduce the quantity of item by the value of quantity in the cart
	 * @param cart
	 * @param item
	 * @param quantity
	 * @return
	 */
	public FoodCart reduceQuantity(int cart_id,int item_id, int quantity);
	
	/**
	 * This removeItem method will remove the item from the cart
	 * @param cart
	 * @param item
	 * @return
	 */
	public String removeItem(FoodCart cart,Item item);
	
	/**
	 * This clearCart method will clear all the items in the cart
	 * @param cart
	 * @return
	 */
	public String clearCart(int cartId);
	
	/**
	 * This findbyCartId method will return the foodCart by the cartId
	 * @param CartId
	 * @return
	 */
	public FoodCart getCartById(int cartId);
	
	public Item getItemById(int itemId);

	

	


}
