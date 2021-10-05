package com.capgemini.OFDApp.serviceImpl;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.OFDApp.respository.*;
import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.service.IRestaurantService;
@Service
@Transactional
public class IRestaurantServiceImpl implements IRestaurantService {
	/**
	 * Restaurant Repository is autowired
	 */
	@Autowired
	IRestaurantRepository irRep;
	@Autowired
	IItemRepository itemRep;
	@Autowired
	IAddressRepository addressRep;
	/**
	 * Implementation of addRestauarnt method to add a Restaurant
	 */
	@Override
	public Restaurant addRestaurant(Restaurant res) {
		
//		List<Item> list=res.getItemList();
//		for(Item i: list)	{
//			i.setRestaurants(null);
//			itemRep.save(i);
//		}
		Address address=res.getAddress();
		address.setRestaurant(res);
//		addressRep.save(address);
		irRep.save(res);
		return res;
	}
	/**
	 * Implementation of viewRestaurant method to view a Restaurant
	 */
	@Override
	public Restaurant viewRestaurant(Restaurant res) {
		
		return irRep.findById(res.getRestaurantId()).orElseThrow(()->new EntityNotFoundException("No details!"));
	}
	/**
	 * Implementation of updateRestaurant method to update existing Restaurant
	 */
	@Override
	public Restaurant updateRestaurant(Restaurant res) {
		
		Restaurant r=irRep.findById(res.getRestaurantId()).orElseThrow(()->new EntityNotFoundException("No details!"));
		r.setRestaurantName(res.getRestaurantName());
		return irRep.save(r);
	}
	/**
	 * Implementation of removeRestaurant method to remove existing Restaurant
	 */
	@Override
	public Restaurant removeRestaurant(Restaurant res) {
		irRep.delete(res);
		return null;
	}
	/**
	 * Implementation of viewRestaurantByItemname method to view item in restaurant
	 */
	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) {
			
		return irRep.findByName(name);
	}
	/**
	 * Implementation of viewNearByRestaurant method to view near by restaurant
	 */
	@Override
	public List<Restaurant> viewNearByRestaurant(String location) {
		
		return irRep.findByLocation(location);
	}

	
	/**
	 * Implementation of viewAllRes method to view All Restaurants
	 * @param restaurant1
	 * @return
	 */
	public List<Restaurant> viewAllRes(Restaurant restaurant1) {
	
		return null;
	}

	
	 

}