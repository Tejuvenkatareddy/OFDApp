package com.capgemini.OFDApp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The FoodCart Class is a domain, which represents data and it will be moving layer to layer
 * @author Sreeraj R
 * 
 *
 */

@Entity
@Table(name="foodcart_master")
public class FoodCart{
	
	/**
	 * Id of the Cart
	 * Primary Key and Auto generated
	 */
	@Id
	@Column(name="cartid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int cartId;
	
	/**
	 * customer owing the cart
	 * OnetoOne relation with customer
	 */
	@OneToOne
	@JoinColumn(name = "cust_id", referencedColumnName = "customerId")
	private Customer customer;
	
	/**
	 * List of items 
	 * One to many relation with customer 
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name ="cart_item_list", joinColumns = { @JoinColumn(name = "cartId")}, inverseJoinColumns = {@JoinColumn(name = "item_id")})
	private List<Item> itemlist = new ArrayList<>();
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JsonIgnore
	private OrderDetails orderDetails;
	
	public FoodCart() {
		super();
	}
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	public List<Item> getItemList() {
		return itemlist;
	}
	public void setItemList(List<Item> itemlist) {
		this.itemlist = itemlist;
		
	}

	public List<Item> getItemlist() {
		return itemlist;
	}

	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
	}

	public OrderDetails getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(OrderDetails orderDetails) {
		this.orderDetails = orderDetails;
	}

	
}
