package com.capgemini.OFDApp.serviceImpl;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.domain.*;
import com.capgemini.OFDApp.respository.*;
import com.capgemini.OFDApp.service.IOrderService;
@Service
@Transactional
public class IOrderServiceimpl implements IOrderService{
	@Autowired
	IOrderRepository ioRep;
	@Override
	public OrderDetails addOrder(OrderDetails order) {
		
		return ioRep.save(order);
	}

	@Override
	public OrderDetails viewOrder(OrderDetails order) {
		
		return ioRep.findById(order.getOrderId()).orElseThrow(()->new EntityNotFoundException("No details!"));
	}

	@Override
	public OrderDetails updateOrder(OrderDetails order) {
		OrderDetails od=ioRep.findById(order.getOrderId()).orElseThrow(()->new EntityNotFoundException("No details!"));
		return null;
	}

	@Override
	public OrderDetails DeleteOrder(OrderDetails order) {
		ioRep.delete(order);
		return null;
	}

	@Override
	public List<OrderDetails> viewAllOrders(Customer customer) {
		
		return ioRep.findOrders(customer);
	}

	@Override
	public List<OrderDetails> viewAllOrders(Restaurant res) {
		
		return ioRep.findOrder(res);
	}

}
