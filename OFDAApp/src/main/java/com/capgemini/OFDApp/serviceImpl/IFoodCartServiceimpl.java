package com.capgemini.OFDApp.serviceImpl;

import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.OFDApp.domain.Customer;
import com.capgemini.OFDApp.domain.FoodCart;
import com.capgemini.OFDApp.domain.Item;
import com.capgemini.OFDApp.domain.Restaurant;
import com.capgemini.OFDApp.exceptions.CartIdException;
import com.capgemini.OFDApp.exceptions.CustomerIdException;
import com.capgemini.OFDApp.exceptions.ItemIdException;
import com.capgemini.OFDApp.exceptions.RestaurantIdIdException;
import com.capgemini.OFDApp.respository.ICustomerRepository;
import com.capgemini.OFDApp.respository.IFoodCartRepository;
import com.capgemini.OFDApp.respository.IItemRepository;
import com.capgemini.OFDApp.service.IFoodCartService;



/**
 * The CartServiceImpl class is a service Implementation, to implement the business logic of FoodCart
 * @author Sreeraj R
 *
 */
@Service
@Transactional
public class IFoodCartServiceimpl implements IFoodCartService {
	
	
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IFoodCartRepository cartRepository;
	
	@Autowired
	IItemRepository itemRepository;
	
	@Override
	public FoodCart createCart(FoodCart cart, Integer customerId) {

		Customer customer = (customerRepository.findById(customerId)).orElse(null);
		if(customer == null) {
			throw new CustomerIdException("Customer id doesn't exixts...");
		}
		cart.setCustomer(customer);
		return cartRepository.save(cart);
	}
	
	@Override
	public FoodCart addItemToCart(int cartId, int itemId) {
		
		FoodCart cart=cartRepository.findById(cartId).orElse(null);
		FoodCart cart1=new FoodCart();
		Item item=itemRepository.findById(itemId).orElse(null);
		if(item==null) {
			throw new ItemIdException("Item id doesn't exists......");
		}
		int size=cart.getItemList().size();
		if(size==0)
		{
			item.setQuantity(1);
			cart.getItemList().add(item);
		    cart1=cartRepository.save(cart);			
		}
		else
		{
			List<Restaurant> list=item.getRestaurants();
			for(Restaurant res: list)	{
			int new_rid=res.getRestaurantId();
			int old_rid=cart.getItemList().get(0).getRestaurants().get(0).getRestaurantId();
			if(new_rid==old_rid)
			{
				item.setQuantity(1);
				cart.getItemList().add(item);
			    cart1=cartRepository.save(cart);
			}
			else
			{
				throw new RestaurantIdIdException("Items are not from same restaurant...");
			}
			}
		}
		return cart1;
	}

	@Override
	public FoodCart increaseQuantity(int cart_id,int item_id, int quantity) {
		
		FoodCart cart=cartRepository.findById(cart_id).orElse(null);
		if(cart==null) {
			throw new CartIdException("CartId doesn't exists.....");
		}
		List<Item> list=cart.getItemList();		
		int size=list.size();
		for(int i=0;i<size;i++)
		{
			int id=list.get(i).getItemId();
			if(item_id==id)
			{
				list.get(i).setQuantity(list.get(i).getQuantity()+quantity);
				break;
			}
			
		}
		return cart;
	
	}

	@Override
	public FoodCart reduceQuantity(int cart_id,int item_id, int quantity) {
		
		FoodCart cart=cartRepository.findById(cart_id).orElse(null);
		if(cart==null) {
			throw new CartIdException("CartId doesn't exists");
		}
		List<Item> list=cart.getItemList();		
		int size=list.size();
		for(int i=0;i<size;i++)
		{
			int id=list.get(i).getItemId();
			if(item_id==id)
			{
				if(list.get(i).getQuantity()< quantity) {
					throw new ItemIdException("Quantiy is not present in the cart");
				}
				list.get(i).setQuantity(list.get(i).getQuantity()-quantity);
				break;
			}
			
		}
		return cart;
	}

	@Override
	public String removeItem(FoodCart cart, Item item) {
		List<Item> list=cart.getItemList();
		int id=item.getItemId();
		int isPresent=0;
		int index=0;
		for(int i=0;i<list.size();i++)
		{
			if(id==list.get(i).getItemId())
			{
				isPresent=1;
				index=i;
				break;
			}
			
		}
		if(isPresent==1)
		{
			list.remove(index);
		}
		cart.setItemList(list);
		cartRepository.save(cart);
		return "Item removed successfully...";
	}
	
	@Override
	public String clearCart(int cartId) {
		FoodCart cart=cartRepository.findById(cartId).orElse(null);
		List<Item> item=cart.getItemList();
		item.clear();
		return "Cart cleared....";
	}

	@Override
	public FoodCart getCartById(int cartId) {
		System.out.println(cartId);
		FoodCart cart=cartRepository.findById(cartId).orElse(null);
		System.err.println(cart);
		return cart;
	}

	@Override
	public Item getItemById(int itemId) {
		return itemRepository.findById(itemId).orElse(null);
	}

}
