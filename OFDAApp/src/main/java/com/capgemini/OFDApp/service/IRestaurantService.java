package com.capgemini.OFDApp.service;

import java.util.List;

import com.capgemini.OFDApp.domain.*;
/**This IBillService interface will hold the functionality for Bill Related
 * Business logic
 * @author thejhv
 *
 */
public interface IRestaurantService {
	/**
	 * This method is used to add Restaurant to database
	 * @param res
	 * @return
	 */
	
	public Restaurant addRestaurant(Restaurant res);
	/**
	 * This method is used to view the Restaurant
	 * @param res
	 * @return
	 */
	
	public Restaurant viewRestaurant(Restaurant res);
	/**
	 * This method is used to update Restaurant
	 * @param res
	 * @return
	 */
	
	public Restaurant updateRestaurant(Restaurant res);
	/**
	 * This  method is used to remove Restaurant
	 * @param res
	 * @return
	 */
	public String removeRestaurant(Restaurant res);
	/**
	 * This method is used to viewRestaurant By Item Name
	 * @param name
	 * @return
	 */
	
	public List<Restaurant> viewRestaurantByItemName(String name);
	/**
	 * This method is used to  viewNearByRestaurant
	 * @param location
	 * @return
	 */
	
	public List<Restaurant> viewNearByRestaurant(String location);

}
