package com.capgemini.OFDApp.serviceImpl;
import java.util.List;

import java.util.Optional;

import javax.persistence.*;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.OFDApp.*;
import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.respository.*;
import com.capgemini.OFDApp.service.ICustomerService;
/**
 * The ICustomerServiceImpl class is a service Implementation, to implement the business logic of OrderDetails
 * @author Subhasree
 *
 */
@Service
@Transactional
public class ICustomerServiceimpl implements ICustomerService{

	@Autowired
	ICustomerRepository iRep;
	@Override
	public Customer addCustomer(Customer customer) {
		
		Address address=customer.getAddress();
		address.setCustomer(customer);
		
		return iRep.save(customer);
	}


	public Customer viewCustomer(Customer customer) {
		
	Customer cust= iRep.getById(customer.getCustomerId());
	
	//Optional<Customer> customerOptional=iRep.findById(customer.getCustomerId());
	return cust;
	
	}

	@Override
	public Customer updateCustomer(Customer customer) {
	
		iRep.save(customer);
		return customer;
		 
	}

	@Override
	public String removeCustomer(Customer customer) {
		
		iRep.delete(customer);
	  return "customer with id "+customer.getCustomerId()+ " is deleted";
	}


	@Override
	public List<Customer> viewAllCustomers(Restaurant res) {
		//return (List<Customer>) iRep.findAll();
		
		return iRep.findAll();
	}


	
//	  public List<Customer> viewAllCus(Customer customer1) {
//	  
//	  return iRep.findAll(); }
	 
}
