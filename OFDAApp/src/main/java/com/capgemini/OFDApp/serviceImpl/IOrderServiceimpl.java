package com.capgemini.OFDApp.serviceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.capgemini.OFDApp.domain.Customer;
import com.capgemini.OFDApp.domain.FoodCart;
import com.capgemini.OFDApp.domain.Item;
import com.capgemini.OFDApp.domain.OrderDetails;
import com.capgemini.OFDApp.domain.Restaurant;
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
@Component
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
		/*order.setOrderStatus(PENDING);
		FoodCart cart = cartRepository.findByCartId(order.getFoodcart().getCartId());
		order.setFoodcart(cart);
		return orderRepository.save(order);*/

		OrderDetails order=new OrderDetails();
		FoodCart cart=cartRepository.findById(cartId).orElse(null);
		/*List<Item> orderList=new ArrayList<Item>();
		
		List<Item> item1=cart.getItemlist();
		int list_size=item1.size();
		for(int i=0;i<list_size;i++)
		{
			Item item=item1.get(i);
			orderList.add(item);
		}
		Restaurant rest=item1.get(0).getRestaurant();
		order.setCustomer(cart.getCustomer());
		order.setRestaurant(rest);
		order.setList(orderList);
		order.setOrderDate(LocalDateTime.now());*/
		order.setOrderStatus("Pending");
		order.setFoodcart(cart);
		orderRepository.save(order);
		//cartService.clearCart(cartId);		
		return order;
	}

	@Override
	public OrderDetails viewOrder(int id) {
		/*OrderDetails order1 = orderRepository.findByOrderId(order.getOrderId());
		if(order1== null) {
			throw new EntityNotFoundException("Could not find the order");
		}
		return order1;*/
		OrderDetails order=orderRepository.findById(id).orElse(null);
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
		
		//List<OrderDetails> list = orderRepository.findAllByRestaurant(resName);
		//System.out.println(list);
		//return list;
		return null;
	}

}
