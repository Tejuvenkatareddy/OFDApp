package com.capgemini.OFDApp.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.OFDApp.domain.Address;

public interface IAddressRepository extends JpaRepository<Address, Integer>{
	
}
