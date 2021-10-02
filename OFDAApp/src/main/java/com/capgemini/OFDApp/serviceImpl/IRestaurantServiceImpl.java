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

	@Autowired
	IRestaurantRepository irRep;
	@Override
	public Restaurant addRestaurant(Restaurant res) {
		
		return irRep.save(res);
	}

	@Override
	public Restaurant viewRestaurant(Restaurant res) {
		
		return irRep.findById(res.getRestaurantId()).orElseThrow(()->new EntityNotFoundException("No details!"));
	}

	@Override
	public Restaurant updateRestaurant(Restaurant res) {
		
		Restaurant r=irRep.findById(res.getRestaurantId()).orElseThrow(()->new EntityNotFoundException("No details!"));
		r.setResturantName(res.getResturantName());
		return irRep.save(r);
	}

	@Override
	public Restaurant removeRestaurant(Restaurant res) {
		irRep.delete(res);
		return null;
	}

	@Override
	public List<Restaurant> viewRestaurantByItemName(String name) {
			
		return irRep.findByName(name);
	}

	public List<Restaurant> viewBearByRestaurant(String location) {
		
		return irRep.findByLocation(location);
	}

	
	
	public List<Restaurant> viewAllRes(Restaurant restaurant1) {
	
		return null;
	}

	
	 

}
