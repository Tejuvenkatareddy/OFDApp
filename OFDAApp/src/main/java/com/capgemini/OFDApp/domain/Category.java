package com.capgemini.OFDApp.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * This class will be working as a data traveler object from layer to layer
 * @author thejhv
 *
 */
@Entity
@Table(name="category_master")
public class Category {
	/*
	 * Id of Category
	 */
	@Id
	@Column(name="orderid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int catId;
	/*
	 * Name of the Category
	 */
	@Column(name="catname")
	private String catName;
	/*
	 * OneToOne relationship with Item
	 */
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="itemid")
	private Item item;
	/*
	 * Getters And Setters
	 */
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getCatName() {
		return catName;
	}
	public void setCatName(String catName) {
		this.catName = catName;
	}
	//@JsonIgnore
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}

}
