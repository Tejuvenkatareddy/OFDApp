package com.capgemini.OFDApp.domain;

import java.time.LocalDateTime;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * This OrderDetails class is a domain, which represents data and it will be moving layer to layer
 * @author Sreeraj R
 *
 */
@Entity
@Table(name="order_master")
public class OrderDetails {
	/**
	 * Id of the Order
	 * Primary Key and Auto generated
	 */
	@Id
	@Column(name="orderId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int orderId;
	
	/**
	 * Date at which the order placed
	 */
	@Column
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime orderDate;
	
	/**
	 * Status of the order
	 */
	@Column
	private String  orderStatus;
	
	/**
	 * Cart of the user
	 */
	@OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "cart_id", referencedColumnName = "cartId")
	@JsonIgnore
	private FoodCart foodcart;
	
	/**
	 * Bill details of the order
	 */
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private Bill bill;
	
	@OneToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;
	
	@ManyToMany
	@JoinTable(name="orderItemDetails", joinColumns = { @JoinColumn(name="orderId")},inverseJoinColumns = {@JoinColumn(name="itemId")})
	List<Item> list;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	Restaurant restaurant;
	
	public OrderDetails() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public FoodCart getFoodcart() {
		return foodcart;
	}
	public void setFoodcart(FoodCart foodcart) {
		this.foodcart = foodcart;
	}
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}
	
	@PrePersist
	protected void  onCreate () {
		this.orderDate = LocalDateTime.now();
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Item> getList() {
		return list;
	}
	public void setList(List<Item> list) {
		this.list = list;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	
	

}
