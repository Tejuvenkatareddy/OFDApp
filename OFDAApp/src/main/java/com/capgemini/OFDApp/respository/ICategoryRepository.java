package com.capgemini.OFDApp.respository;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Category Repository
 * @author thejhv
 */

import com.capgemini.OFDApp.domain.*;
/**
 * Category Repository
 * @author thejhv
 *
 */
public interface ICategoryRepository extends JpaRepository<Category,Integer>{

}
