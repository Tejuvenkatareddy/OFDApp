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
import com.capgemini.OFDApp.serviceImpl.*;
/**
 * This is the ICustomerController and it is used for handling front end calls and generate json response. 
 * @author subhasree
 *
 */

@RestController
@RequestMapping("/Customers")
public class ICustomerController {
	
	@Autowired
	ICustomerServiceimpl iservice;
	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public Customer addCustomer(@RequestBody Customer customer)
	{
	return	iservice.addCustomer(customer);
	}
    @PostMapping("/view")
	public Customer viewCustomer(@RequestBody Customer customer)
	{
		return iservice.viewCustomer(customer);
		
	}
	@PutMapping("/update")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		 return iservice.updateCustomer(customer);
	}
	@DeleteMapping("/remove")
	public String removeCustomer(@RequestBody Customer customer)
	{
		 return iservice.removeCustomer(customer);
		
	}
	
    @GetMapping("/all")
	public List<Customer> viewAllCustomers(Restaurant res)
	{
		return iservice.viewAllCustomers(res);
		
	}
}
