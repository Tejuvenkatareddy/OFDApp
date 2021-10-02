package com.capgemini.OFDApp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.OFDApp.domain.*;

public interface IFoodCartRepository  extends JpaRepository<FoodCart,Integer> {
	//@Query("Update Item Set quantity=?1")
	//FoodCart save(Item item);
//@Query("Update Item Set quantity=?1")
	//FoodCart update(FoodCart cart, Item item, Integer quantity);
	//@Query("Update  Item  Set quantity = ?1 ")
	//FoodCart increaseQ(FoodCart cart, Item item, int quantity);

	//FoodCart update(FoodCart cart
	

}
