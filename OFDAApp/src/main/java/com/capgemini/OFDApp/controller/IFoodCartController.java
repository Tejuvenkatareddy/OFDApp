package com.capgemini.OFDApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.serviceImpl.*;

@RestController

@RequestMapping("/FoodCarts")

@Component
public class IFoodCartController {
	@Autowired(required=true)
	IFoodCartServiceimpl icsService;

	
	@PostMapping
	 
	 @ResponseStatus(HttpStatus.CREATED)
	 public FoodCart addThemToCart(@RequestBody FoodCart cart, Item item)
	 {
	 return icsService.addItemToCart(cart, item);
	 }
	

	@PutMapping("/increaseQ")
	 
	//@ResponseStatus(HttpStatus.CREATED)
	 public FoodCart increaseQuantity(@RequestBody FoodCart cart, Item item,Integer quantity)
	 {
	 return icsService.increaseQuantity(cart, item, quantity);
	 }
	

	@PutMapping("/reduceQ/q")
	 
	//@ResponseStatus(HttpStatus.CREATED)
	 public FoodCart reduceQuantity(@RequestBody FoodCart cart, Item item,Integer quantity)
	 {
	 return icsService.reduceQuantity(cart, item, quantity);
	 }
	@DeleteMapping("/remove")
	public FoodCart removeItem(FoodCart cart,Item item)
	{
		return icsService.removeItem(cart, item);
	}
	
	@DeleteMapping("/clear")
	public  FoodCart clearCart(FoodCart cart)
	{
		return icsService.clearCart(cart);
	}
	
}
