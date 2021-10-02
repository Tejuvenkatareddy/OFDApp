package com.capgemini.OFDApp.service;

import java.util.List;

import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.domain.*;

public interface ICustomerService {
	
	public Customer addCustomer(Customer customer);
	public Customer viewCustomer(Customer customer);
	public Customer updateCustomer(Customer customer);
	public Customer removeCustomer(Customer customer);
	public List<Customer> viewAllCustomers(Restaurant res);

}
