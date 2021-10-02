package com.capgemini.OFDApp.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.OFDApp.domain.*;

public interface ICategoryRepository extends JpaRepository<Category,Integer>{

}
