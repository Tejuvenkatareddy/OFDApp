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
	/*
	 * Name of restaurant
	 */
	@Column
	private String restaurantName;
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
	@OneToOne(mappedBy="restaurant", cascade = CascadeType.MERGE)
	private Address address;
	/*
	 * ManytoMany relationship with Item
	 */
	
	@ManyToMany(cascade=CascadeType.MERGE)
	//@Column(name="itemid")
	@JoinTable(name="restaurant_item_table", joinColumns = @JoinColumn(name="restaurantId"), 
			inverseJoinColumns = @JoinColumn(name="itemId"))
	@JoinColumn(name="itemid")
	private List<Item> itemList;
	/*
	 * Getters and Setters
	 */
	public int getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
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
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	
	

}
