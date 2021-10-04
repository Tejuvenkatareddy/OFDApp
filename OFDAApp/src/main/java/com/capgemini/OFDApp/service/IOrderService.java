package com.capgemini.OFDApp.service;

import java.util.*;

import com.capgemini.OFDApp.domain.*;

/**
 * The IOrderService interface is a service, which is used to implement the business Logic of order
 * @author Sreeraj R
 *
 */

public interface IOrderService {
	
	final static String PENDING = "PENDING";
	final static String DELIVERED = "Delivered";

	/**
	 * This addOrder method will save the order
	 * @param order details
	 * @return Order details
	 */
	public OrderDetails addOrder(int cartId);
	
	/**
	 * This viewOrder method will return the order details
	 * @param order details
	 * @return Order details
	 */
	public OrderDetails viewOrder(int id);
	
	/**
	 * This updateOrder method will update the order
	 * @param order details
	 * @return Order details
	 */
	public OrderDetails updateOrder(OrderDetails order);
	
	/**
	 * This removeOrder method will remove the order
	 * @param order details
	 * @return Order details
	 */
	public String removeOrder(OrderDetails order);
	
	/**
	 * This viewAllOrder method will view List of orders by customer
	 * @param order details
	 * @return Order details
	 */
	public List<OrderDetails> viewAllOrders(int id);
	
	/**
	 * This viewAllOrder method will view List of orders by restaurant
	 * @param order details
	 * @return Order details
	 */
	public List<OrderDetails> viewAllOrders(String resname);

	
}
