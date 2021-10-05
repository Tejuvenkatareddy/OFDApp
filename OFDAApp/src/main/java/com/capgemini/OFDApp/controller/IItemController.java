package com.capgemini.OFDApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.serviceImpl.*;

/**
 * This is the item controller class
 * @author arkap
 *
 */
@RestController
@RequestMapping("/Items")
public class IItemController {
	
	
	@Autowired
	IItemServiceimpl itservice;
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Item addItem (@RequestBody Item  item)
	{
	return	itservice.addItem ( item);
	}
	@GetMapping
	public Item  viewItem (Item  item)
	{
		return itservice.viewItem ( item);
		
	}
	@PutMapping
	public Item  updateItem (@RequestBody Item  item)
	{
		return itservice.updateItem ( item);
	}
	@DeleteMapping
	public Item  removeCustomer(Item  item)
	{
		return itservice.removeItem ( item);
	}
	@GetMapping("/itemsInCategory")
	public List<Item> viewAllItems (Category cat)
	{
		return itservice.viewAllItems(cat);
		
	}
	@GetMapping("/itemsInRestaurant")
	public List<Item> viewAllItems(Restaurant res)
	{
		return itservice.viewAllItems(res);
		
	}
	@GetMapping("/itemss")
	public List<Item> viewAllItemsByName(String name)
	{
		return itservice.viewAllItemsByName(name);
		
	}


}
