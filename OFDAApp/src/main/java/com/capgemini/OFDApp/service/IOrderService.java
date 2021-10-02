package com.capgemini.OFDApp.service;

import java.util.*;

import com.capgemini.OFDApp.domain.*;

public interface IOrderService {

	public OrderDetails addOrder(OrderDetails order);
	
	public OrderDetails viewOrder(OrderDetails order);
	
	public OrderDetails updateOrder(OrderDetails order);
	
	public OrderDetails DeleteOrder(OrderDetails order);
	
	public List<OrderDetails> viewAllOrders(Customer customer);
	public List<OrderDetails> viewAllOrders(Restaurant res);
	
}
