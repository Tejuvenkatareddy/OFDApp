package com.capgemini.OFDApp.serviceImpl;


import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.capgemini.OFDApp.domain.FoodCart;
import com.capgemini.OFDApp.domain.Item;
import com.capgemini.OFDApp.domain.OrderDetails;
import com.capgemini.OFDApp.domain.Restaurant;
import com.capgemini.OFDApp.exceptions.CartIdException;
import com.capgemini.OFDApp.exceptions.OrderIdException;
import com.capgemini.OFDApp.respository.IFoodCartRepository;
import com.capgemini.OFDApp.respository.IItemRepository;
import com.capgemini.OFDApp.respository.IOrderRepository;

import com.capgemini.OFDApp.service.IOrderService;

/**
 * The IOrderServiceImpl class is a service Implementation, to implement the business logic of OrderDetails
 * @author Sreeraj R
 *
 */
@Service
@Transactional

public class IOrderServiceimpl implements IOrderService{
	
	@Autowired
	IOrderRepository orderRepository;
	
	@Autowired
	IFoodCartRepository cartRepository;
	
	@Autowired
	IItemRepository itemRepository;	
	
	@Autowired
	IFoodCartServiceimpl cartService;
	
	@Override
	public OrderDetails addOrder(int cartId) {

		OrderDetails order=new OrderDetails();
		FoodCart cart=cartRepository.findById(cartId).orElse(null);
		if(cart == null) {
			throw new CartIdException("Cart id doesn't exists...");
		}
		List<Item> orderList=new ArrayList<Item>();
		
		List<Item> item1=cart.getItemList();
		int list_size=item1.size();
		for(int i=0;i<list_size;i++)
		{
			Item item=item1.get(i);
			orderList.add(item);
		}
		Restaurant rest=item1.get(0).getRestaurants().get(0);
		order.setCustomer(cart.getCustomer());
		order.setRestaurant(rest);
		order.setList(orderList);
		order.setOrderStatus(IOrderService.PENDING);
		order.setFoodcart(cart);
		orderRepository.save(order);		
		return order;
	}

	@Override
	public OrderDetails viewOrder(int id) {
		OrderDetails order=orderRepository.findById(id).orElse(null);
		if(order ==null) {
			throw new OrderIdException("Order id doesn't exists...");
		}
		System.out.println("View list in order :"+order.getList());
		order.setList(order.getList());
		return order;
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		OrderDetails order1=orderRepository.save(order);
		return order1;
	}

	@Override
	public String removeOrder(OrderDetails order) {
		orderRepository.delete(order);
		return "Order with id: " + order.getOrderId()  + " removed successfully";
	}

	@Override
	public List<OrderDetails> viewAllOrders(int id) {
		
		List<OrderDetails> list = orderRepository.findAllOrdersByCustomer(id);
		System.out.println(list);
		return list;
	}

	@Override
	public List<OrderDetails> viewAllOrders(String resName) {
		
		List<OrderDetails> list = orderRepository.findAllByRestaurant(resName);
		System.out.println(list);
		return list;
	}

}
