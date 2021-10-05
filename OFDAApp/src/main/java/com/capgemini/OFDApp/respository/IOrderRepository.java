package com.capgemini.OFDApp.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.capgemini.OFDApp.domain.Customer;
import com.capgemini.OFDApp.domain.OrderDetails;
import com.capgemini.OFDApp.domain.Restaurant;



/**
 * The IOrderRepository class is a repository,to implement the CRUD operations on order
 * @author Sreeraj R
 *
 */
@Repository
public interface IOrderRepository extends JpaRepository<OrderDetails,Integer>{
	
	/**
	 * This findByOrderId method will return orderdetails by the orderId
	 * @param orderId
	 * @return
	 */
	public OrderDetails findByOrderId(Integer orderId);

	/**
	 * This viewAllOrder method will view List of orders by customer
	 * @param order details
	 * @return Order details
	 */
	@Query("select o from OrderDetails o where o.customer.customerId=:id")
	public List<OrderDetails> findAllOrdersByCustomer(@Param("id") int id);

	/**
	 * This viewAllOrder method will view List of orders by restaurant
	 * @param order details
	 * @return Order details
	 */
	@Query("select o from OrderDetails o where o.restaurant.restaurantId=(select r.restaurantId from Restaurant r where r.restaurantName=:name)")
	public List<OrderDetails> findAllByRestaurant(@Param("name") String resName);
}
