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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="foodcart_master")
public class FoodCart {
	
	@Id
	@Column(name="cartid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int cartId;
	@OneToOne(mappedBy="foodcart",cascade=CascadeType.ALL)
	private Customer customer;
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="orderid")
	//@JsonIgnore
	private OrderDetails orderdetails;
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@OneToMany(targetEntity=FoodCart.class,cascade=CascadeType.ALL)
	//@JoinColumn(name="cartid")
	private List<Item> itemlist=new ArrayList<>();
	//@JsonIgnore
	public List<Item> getItemlist() {
		return itemlist;
	}
	public void setItemlist(List<Item> itemlist) {
		this.itemlist = itemlist;
		for(Item i: itemlist)
		{
			i.setFoodcart(this);;
		}
	}

}
