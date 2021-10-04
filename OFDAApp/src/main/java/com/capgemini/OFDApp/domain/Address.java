package com.capgemini.OFDApp.domain;
import javax.persistence.*;

/**
 * This address Class is a domain, which represents data and it will be moving
 * layer to layer.
 * 
 * @author Subhasree
 *
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="address_master")
public class Address {
	
	@Id
	@Column(name="addressid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	/*
	 * id of address is autogenerated
	 */
	private int addressId;
	@Column
	/*
	 * building name in address
	 */
	private String buildingName;
	@Column
	/*
	 * street number in address
	 */
	private String streetNo;
	@Column
	/*
	 * area in the address
	 */
	private String area;
	@Column
	/*
	 * city in the address
	 */
	private String city;
	@Column
	/*
	 * state in the address
	 */
	private String state;
	@Column
	/*
	 * country in the address
	 */
	private String country;
	@Column
	/*
	 * pincode in the address
	 */
	private String pincode;
	/*
	 * setters and getters
	 */
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(String streetNo) {
		this.streetNo = streetNo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
@JsonIgnore
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
/*
 * one to one relation with customer
 */
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="customerid")
	private Customer customer;
	/*
	 * one to one relation with restaurant
	 */
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="restaurantid")
	private Restaurant restaurant;
	@JsonIgnore
	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
