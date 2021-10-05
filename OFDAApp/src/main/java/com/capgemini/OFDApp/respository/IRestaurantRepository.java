package com.capgemini.OFDApp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.OFDApp.domain.*;
/**
 * Reatuarnt Repository
 * @author thejhv
 *
 */
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{
	/**
	 * Query for Finding the Restaurant By Name
	 * @param name
	 * @return
	 */
@Query("Select r from Restaurant r where resturant_name=?1")
	//@Query("Select r From item_master_restaurants where ")
	List<Restaurant> findByName(String name);
/**
 * Query for finding the Restaurant By Location
 * @param location
 * @return
 */
@Query("Select r1 From Address r1 where area=?1")
List<Restaurant> findByLocation(String location);

}
