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
	/**
	 * this method is used to add the item
	 * @param item
	 * @return
	 */
	@PostMapping ("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Item addItem (@RequestBody Item  item)
	{
	return	itservice.addItem ( item);
	}
	/**
	 * this method is used to view the items
	 * @param item
	 * @return
	 */
	@PostMapping ("/view")
	public Item  viewItem (@RequestBody Item  item)
	{
		return itservice.viewItem ( item);
		
	}
	/**
	 * this method is used to update the item
	 * @param item
	 * @return
	 */
	@PutMapping ("/update")
	public Item  updateItem (@RequestBody Item  item)
	{
		return itservice.updateItem ( item);
	}
	/**
	 * this method is used to remove item
	 * @param item
	 * @return
	 */
	@DeleteMapping ("/remove")
	public Item  removeCustomer(@RequestBody Item  item)
	{
		return itservice.removeItem ( item);
	}
	/**
	 * this method is used to view items in categories
	 * @param cat
	 * @return
	 */
	@PostMapping("/itemsInCategory")
	public List<Item> viewAllItems (@RequestBody Category cat)
	{
		return itservice.viewAllItems(cat);
		
	}
	/**
	 * this method used to view items in Restaurant
	 * @param res
	 * @return
	 */
	@PostMapping("/itemsInRestaurant")
	public List<Item> viewAllItems(@RequestBody Restaurant res)
	{
		return itservice.viewAllItems(res);
		
	}
	/**
	 * this method used to view all items by name
	 * @param name
	 * @return
	 */
	@PostMapping("/items")
	public List<Item> viewAllItemsByName(@RequestBody String name)
	{
		return itservice.viewAllItemsByName(name);
		
	}


}
