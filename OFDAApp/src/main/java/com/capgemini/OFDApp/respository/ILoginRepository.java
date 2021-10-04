package com.capgemini.OFDApp.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.OFDApp.domain.Login;

/**
 * Login repository
 * @author Soumyadip Pal
 *
 */
@Repository
public interface ILoginRepository extends JpaRepository<Login, Integer>{
	
	Login findByUserName(String userName);
	Optional<Login> findById(Integer id);
}
