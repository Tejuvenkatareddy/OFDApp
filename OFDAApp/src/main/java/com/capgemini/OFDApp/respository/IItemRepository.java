package com.capgemini.OFDApp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.OFDApp.*;
import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.domain.*;

public interface IItemRepository extends JpaRepository<Item,Integer>{
@Query("Select c From Category c")
	List<Item> findAllItems(Category cat);
@Query("Select r From Restaurant r")
	List<Item> findAllItem(Restaurant res);
@Query("Select i From Item i where item_name=?1")
	List<Item> find(String name);

}
