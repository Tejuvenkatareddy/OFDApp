package com.capgemini.OFDApp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.OFDApp.domain.*;

/**
 * The IFoodCartRepository class is a repository,to implement the CRUD operations on cart
 * @author Sreeraj R
 *
 */
@Repository
public interface IFoodCartRepository  extends JpaRepository<FoodCart,Integer> {
	//@Query("Update Item Set quantity=?1")
	//FoodCart save(Item item);
//@Query("Update Item Set quantity=?1")
	//FoodCart update(FoodCart cart, Item item, Integer quantity);
	//@Query("Update  Item  Set quantity = ?1 ")
	//FoodCart increaseQ(FoodCart cart, Item item, int quantity);

	//FoodCart update(FoodCart cart
	/**
	 * This findByCartId method returns the cart by the id given
	 * @param cartId
	 * @return
	 */
	public FoodCart findByCartId(Integer cartId);

}
