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
import com.capgemini.OFDApp.serviceImpl.*;


@RestController
@RequestMapping("/Restaurants")
public class IRestaurantController {
	/**
	 * Restaurant Service is Autowired
	 */
	@Autowired
	IRestaurantServiceImpl irservice;
	/**
	 * To add Restaurant
	 * return : res
	 * @param res
	 * @return
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurant addRestaurant(@RequestBody Restaurant res)
	{
	return	irservice.addRestaurant(res);
	}
	@GetMapping
	public Restaurant viewRestaurant(Restaurant res)
	{
		return irservice.viewRestaurant(res);
		
	}
	/**
	 * To modify a Restaurant
	 * return : res
	 * @param res
	 * @return
	 */
	@PutMapping
	public Restaurant updateRestaurant(@RequestBody Restaurant res)
	{
		return irservice.updateRestaurant(res);
	}
	/**
	 * To remove a Restaurant
	 * return : void
	 * @param res
	 * @return
	 */
	@DeleteMapping
	public Restaurant removeRestaurant(Restaurant res)
	{
		return irservice.removeRestaurant(res);
	}
	/**
	 * To retrieve an Restaurant
	 * return : res
	 * @param name
	 * @return
	 */
	@GetMapping("/{name}")
	public List<Restaurant> viewRestaurantByItemName(String name)
	{
		return irservice.viewRestaurantByItemName(name);
		
	}
	/**
	 * To retrieve all Restaurants
	 * return : List<restaurants>
	 * @param location
	 * @return
	 */

	@GetMapping("/{area}")
	public List<Restaurant> viewBearByRestaurant(String location)
	{
		return irservice.viewNearByRestaurant(location);
		
	}

}