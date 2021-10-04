package com.capgemini.OFDApp.service;

import java.util.List;

import com.capgemini.OFDApp.domain.*;
/**This IBillService interface will hold the functionality for Bill Related
 * Business logic
 * @author thejhv
 *
 */
public interface ICategoryService {
	/**
	 * This method is used to add Category to database
	 * @param cat
	 * @return
	 */

	public Category addCategory(Category cat);
	/**
	 * This method is used to view Category
	 * @param cat
	 * @return
	 */
	public Category viewCategory(Category cat);
	/**
	 * This method is used to update category
	 * @param cat
	 * @return
	 */
	public Category updateCategory(Category cat);
	/**
	 * This method is used to remove Category
	 * @param cat
	 * @return
	 */
	
	public Category removeCategory(Category cat);
	/**
	 * This method used viewAllCategory
	 * @param cat
	 * @return
	 */
	
	public List<Category> viewAllCategory(Category cat);
}
