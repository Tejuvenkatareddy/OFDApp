package com.capgemini.OFDApp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.OFDApp.domain.OrderDetails;
import com.capgemini.OFDApp.service.IFoodCartService;
import com.capgemini.OFDApp.service.IOrderService;


/**
 * The IOrderController class is used to control the transactions on OrderDetails
 * @author Sreeraj R
 *
 */
@RestController
@RequestMapping("api/Orders")
public class IOrderController {
	
	@Autowired
	IOrderService orderService;
	
	@Autowired
	IFoodCartService cartService;
	

	@PostMapping("/addOrder/{cartId}")
	public ResponseEntity<OrderDetails> addOrder(@PathVariable("cartId") int cartId)
	{
		OrderDetails order2 =orderService.addOrder(cartId);
	   	return new ResponseEntity<OrderDetails>(order2,HttpStatus.OK);
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<OrderDetails> updateOrder(@Valid @RequestBody OrderDetails order)
	{
		OrderDetails order1=orderService.viewOrder(order.getOrderId());
        order.setOrderDate(order1.getOrderDate());
        order.setFoodcart(order1.getFoodcart());
        order.setCustomer(order1.getCustomer());
        order.setList(order1.getList());
			OrderDetails order2 =orderService.updateOrder(order);
			return new ResponseEntity<OrderDetails>(order2,HttpStatus.OK);
	}
	
	@DeleteMapping("/removeOrderByOrderId/{orderId}")
	public  ResponseEntity<String> removeOrder(@PathVariable("orderId") int orderId)  
	{
		   OrderDetails order1=orderService.viewOrder(orderId);
	       
	    	  String msg=orderService.removeOrder(order1);
	    	   return new ResponseEntity<String>(msg, HttpStatus.OK);
	       
	}
	
	@GetMapping("/viewOrderByOrderId/{orderId}")
	public ResponseEntity<OrderDetails> viewOrder(@PathVariable("orderId") int orderId) 
	{
		OrderDetails order2 = orderService.viewOrder(orderId);
		
		
			return new ResponseEntity<OrderDetails>(order2, HttpStatus.OK);
		
	
	}
	
	@GetMapping("/viewAllOrdersByRestaurant/{restaurantName}")
	public ResponseEntity<List<OrderDetails>> viewAllOrdersByRestaurant(@PathVariable("restaurantName") String resName) 
	{
		List<OrderDetails> order2 = orderService.viewAllOrders(resName);
		
			return new ResponseEntity<List<OrderDetails>>(order2, HttpStatus.OK);

		
	}
	
	@GetMapping("/viewAllOrdersByCustomer/{customerId}")
	public ResponseEntity<List<OrderDetails>> viewAllOrdersByCustomer(@PathVariable("customerId") int id)  
	{
		List<OrderDetails> order2 = orderService.viewAllOrders(id);
		
			return new ResponseEntity<List<OrderDetails>>(order2, HttpStatus.OK);
		
	}

}
