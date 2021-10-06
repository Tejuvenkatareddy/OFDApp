package com.capgemini.OFDApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.OFDApp.domain.FoodCart;
import com.capgemini.OFDApp.domain.Item;
import com.capgemini.OFDApp.exceptions.CartIdException;
import com.capgemini.OFDApp.exceptions.ItemIdException;
import com.capgemini.OFDApp.service.IFoodCartService;
import com.capgemini.OFDApp.service.IItemService;



/**
 * IFoodCartController class is used to control the transactions on foodcart
 * @author Sreeraj R
 *
 */
@RestController
@RequestMapping("api/FoodCarts")

public class IFoodCartController {
	@Autowired
	IFoodCartService cartService;
	
	@Autowired
	IItemService itemService;
	
	@PostMapping("/{customerId}")
	public ResponseEntity<?> createCart(@PathVariable Integer customerId,@RequestBody FoodCart cart)
	{
		FoodCart savedCart = cartService.createCart(cart, customerId);
		return new ResponseEntity<FoodCart>(savedCart, HttpStatus.CREATED);
	}
	
	@PostMapping("/addItemToCart/{itemId}")
	public ResponseEntity<FoodCart> addItemToCart(@RequestParam("cartId") int cartId,@PathVariable int itemId) {
		
		FoodCart cart1 = cartService.addItemToCart(cartId,itemId);
		return new ResponseEntity<FoodCart>(cart1, HttpStatus.OK);
		
	}
	
	@PutMapping("/increaseQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart> increaseQuantity(@PathVariable("cartId") int cart_id,@PathVariable("itemId") int item_id, @PathVariable int quantity){
		
		FoodCart cart=cartService.increaseQuantity(cart_id,item_id, quantity);
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	@PutMapping("/reduceQuantity/{cartId}/{itemId}/{quantity}")
	public ResponseEntity<FoodCart>  reduceQuantity(@PathVariable("cartId") int cart_id,@PathVariable("itemId") int item_id, @PathVariable int quantity) {
		
		FoodCart cart=cartService.reduceQuantity(cart_id,item_id, quantity);
		
		
		return new ResponseEntity<FoodCart>(cart, HttpStatus.OK);
	}
	
	@DeleteMapping("/removeItem/{cartId}/{itemId}")
	public ResponseEntity<String> removeItem(@PathVariable("cartId") int cartId, @PathVariable("itemId") int itemId) {
		
		FoodCart cart=cartService.getCartById(cartId);
		if(cart == null) {
			throw new CartIdException("Cart doesn't exists....");
		}
		Item item1 = new Item();
		item1.setItemId(itemId);
		Item item=itemService.viewItem(item1);
		if(item == null) {
			throw new ItemIdException("Item Doesn't exists....");
		}
		String msg=cartService.removeItem(cart, item);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
			
	}
	
	@DeleteMapping("/clearCart/{cartId}")
	public ResponseEntity<String>  clearCart(@PathVariable int cartId){	
		String msg=cartService.clearCart(cartId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
}