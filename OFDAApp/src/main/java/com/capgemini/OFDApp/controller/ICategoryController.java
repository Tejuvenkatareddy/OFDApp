package com.capgemini.OFDApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.serviceImpl.*;



@RestController
@RequestMapping("/Categories")
public class ICategoryController {
	/**
	 * Category Service is Autowired
	 */
	@Autowired
	ICategoryServiceimpl icsService;
	/**
	 * to add a category
	 * @param cat
	 * @return category
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Category addCustomer(@RequestBody Category cat)
	{
	return	icsService.addCategory(cat);
	}
	/**
	 * to retrieve a category
	 * @param cat
	 * @return category
	 */
	@GetMapping
	public Category viewCategory(Category cat)
	{
		return icsService.viewCategory(cat);
		
	}
	/**
	 * to retrieve all categories
	 * @param cat
	 * @return List<categories>
	 */
	@GetMapping("/listofall")
	public List<Category> viewAllCategory(Category cat)
	{
		return icsService.viewAllCategory(cat);
		
	}
	/**
	 * to modify a category
	 * @param cat
	 * @return category
	 */
	@PutMapping
	public Category updateCategory(@RequestBody Category cat)
	{
		return icsService.updateCategory(cat);
	}
	/**
	 * to remove a category
	 * @param cat
	 * @return catgeory
	 */
	@DeleteMapping
	public Category removeCategory(Category cat)
	{
		return icsService.removeCategory(cat);
	}
	
}
