package com.capgemini.OFDApp.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * This class will be working as a data traveler object from layer to layer
 * @author thejhv
 *
 */


@Entity
@Table(name="res_master")
public class Restaurant {
	/**
	 * Id of Restaurant 
	 */
	
	@Id
	@Column(name="restaurantid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int restaurantId;
	/**
	 * Name of restaurant
	 */
	@Column
	private String resturantName;
	/*
	 * Getters and Setters
	 */
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getResturantName() {
		return resturantName;
	}
	public void setResturantName(String resturantName) {
		this.resturantName = resturantName;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	/*
	 * Name of the manager
	 */
	@Column
	private String managerName;
	/*
	 * Contact Number
	 */
	@Column
	private String contactNumber;
	/*
	 * OneToOne relationship with address
	 */
	@OneToOne(mappedBy="restaurant")
	private Address address;
	/*
	 * ManytoMany relationship with Item
	 */
	
	@ManyToMany(cascade=CascadeType.ALL)
	//@Column(name="itemid")
	@JoinColumn(name="itemid")
	private List<Item> itemList;
	

}
