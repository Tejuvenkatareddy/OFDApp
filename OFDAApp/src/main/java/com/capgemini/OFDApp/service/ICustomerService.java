package com.capgemini.OFDApp.service;

import java.util.List;

import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.domain.*;

public interface ICustomerService {
	/* definition of addCustomer method for adding new customer */
	public Customer addCustomer(Customer customer);
	/* definition of updateCustomer method for updating customer */
	public Customer viewCustomer(Customer customer);
	/* definition of removeCustomer method for removing customer */
	public Customer updateCustomer(Customer customer);
	/* definition of viewCustomer method for viewing particular customer */
	public String removeCustomer(Customer customer);
	/* definition of viewAllCustomer method for viewing all customers */
	public List<Customer> viewAllCustomers(Restaurant res);

}
