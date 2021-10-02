package com.capgemini.OFDApp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.OFDApp.*;
import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.*;

public interface IOrderRepository extends JpaRepository<OrderDetails,Integer>{

	@Query("SELECT a FROM OrderDetails a INNER JOIN Customer b on a.OrderId= b.customerId")
	List<OrderDetails> findOrders(Customer customer);

	@Query("SELECT a FROM Restaurant a LEFT JOIN OrderDetails b on a.restaurantId=b.OrderId")
	//@Query("Select a from OrderDetails a")
	List<OrderDetails> findOrder(Restaurant res);

}
