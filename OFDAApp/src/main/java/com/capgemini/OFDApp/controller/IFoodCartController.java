package com.capgemini.OFDApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.service.IFoodCartService;
import com.capgemini.OFDApp.service.IItemService;
import com.capgemini.OFDApp.serviceImpl.*;


/**
 * IFoodCartController class is used to control the transactions on foodcart
 * @author Sreeraj R
 *
 */
@RestController
@RequestMapping("api/FoodCarts")
@Component
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
		
		FoodCart cart2=new FoodCart();
		cart2.setCartId(cart1.getCartId());
		cart2.setCustomer(cart1.getCustomer());
		return new ResponseEntity<FoodCart>(cart2, HttpStatus.OK);
		
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
	
	@DeleteMapping("/removeItem")
	public ResponseEntity<String> removeItem(@RequestParam("cartId") int cartId, @RequestParam("itemId") int itemId) {
		
		FoodCart cart=cartService.getCartById(cartId);
		Item item=itemService.viewItem(itemId);
		String msg=cartService.removeItem(cart, item);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
			
	}
	
	@DeleteMapping("/clearCart/{cartId}")
	public ResponseEntity<String>  clearCart(@PathVariable int cartId){	
		String msg=cartService.clearCart(cartId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
	
	
}
