package com.capgemini.OFDApp.domain;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="order_master")
public class OrderDetails {
	
	@Id
	@Column(name="orderid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int OrderId;
	public int getOrderId() {
		return OrderId;
	}
	public void setOrderId(int orderId) {
		OrderId = orderId;
	}
	public LocalDate getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		OrderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}@JsonIgnore
	public FoodCart getFoodcart() {
		return foodcart;
	}
	public void setFoodcart(FoodCart foodcart) {
		this.foodcart = foodcart;
	}
	@Column
	private LocalDate OrderDate;
	@Column
	private String  orderStatus;
	@OneToOne(mappedBy="orderdetails",cascade=CascadeType.ALL)
	private FoodCart foodcart;
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Bill bill;
	@JsonIgnore
	public Bill getBill() {
		return bill;
	}
	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
