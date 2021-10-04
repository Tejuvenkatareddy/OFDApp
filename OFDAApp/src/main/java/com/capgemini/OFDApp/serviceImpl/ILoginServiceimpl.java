package com.capgemini.OFDApp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.OFDApp.domain.Login;
import com.capgemini.OFDApp.respository.ILoginRepository;
import com.capgemini.OFDApp.service.ILoginService;

/**
 * Login service implementation which contains the implementations of the login service interface
 * @author Soumyadip Pal
 *
 */
@Service
public class ILoginServiceimpl implements ILoginService{
	
	@Autowired
	ILoginRepository loginRepo;

	@Override
	public Login signIn(Login login) {
		Login log= loginRepo.findByUserName(login.getUserName());
		return log;
	}

	@Override
	public Login signOut(Login login) {
		Optional<Login> l=loginRepo.findById(login.getId());
		Login log=null;
		if(l.isPresent())
			log=l.get();
		loginRepo.delete(log);
		return log;
	}

	@Override
	public void register(Login login) {
		loginRepo.save(login);
	}

	@Override
	public List<Login> getAll() {
		return loginRepo.findAll();
	}
	
	
}
