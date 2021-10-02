package com.capgemini.OFDApp.service;

import java.util.List;

import com.capgemini.OFDApp.domain.*;

public interface ICategoryService {

	public Category addCategory(Category cat);
	
	public Category viewCategory(Category cat);
	
	public Category updateCategory(Category cat);
	
	public Category removeCategory(Category cat);
	
	public List<Category> viewAllCategory(Category cat);
}
