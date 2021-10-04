package com.capgemini.OFDApp.serviceImpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.respository.*;
import com.capgemini.OFDApp.service.ICategoryService;
@Service
@Transactional
public class ICategoryServiceimpl implements ICategoryService {
	/**
	 * Category Service is autowired
	 */
	@Autowired
	ICategoryRepository icRep;
	/**
	 * Implementation of addCategory method to add a category 
	 */
	@Override
	public Category addCategory(Category cat) {
		
		return icRep.save(cat);
	}
	/**
	 * Implementation of viewCategory method to view a category 
	 */
	@Override
	public Category viewCategory(Category cat) {
		
		return icRep.findById(cat.getCatId()).orElseThrow(()->new EntityNotFoundException("No details!"));
	}
	/**
	 * Implementation of updateCategory method to update a category 
	 */
	@Override
	public Category updateCategory(Category cat) {
		Category ct=icRep.findById(cat.getCatId()).orElseThrow(()->new EntityNotFoundException("No details!"));
		ct.setCatName(cat.getCatName());
		return ct;
	}
	/**
	 * Implementation of removeCategory method to remove a category 
	 */
	@Override
	public Category removeCategory(Category cat) {
		
		icRep.delete(cat);
		return null;
	}
	/**
	 * Implementation of viewAllCategory method to view All categories 
	 */
	@Override
	public List<Category> viewAllCategory(Category cat) {
		
		return icRep.findAll();
	}

}
