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
	
	@Autowired
	ICategoryRepository icRep;
	@Override
	public Category addCategory(Category cat) {
		
		return icRep.save(cat);
	}

	@Override
	public Category viewCategory(Category cat) {
		
		return icRep.findById(cat.getCatId()).orElseThrow(()->new EntityNotFoundException("No details!"));
	}

	@Override
	public Category updateCategory(Category cat) {
		Category ct=icRep.findById(cat.getCatId()).orElseThrow(()->new EntityNotFoundException("No details!"));
		ct.setCatName(cat.getCatName());
		return ct;
	}

	@Override
	public Category removeCategory(Category cat) {
		
		icRep.delete(cat);
		return null;
	}

	@Override
	public List<Category> viewAllCategory(Category cat) {
		
		return icRep.findAll();
	}

}
