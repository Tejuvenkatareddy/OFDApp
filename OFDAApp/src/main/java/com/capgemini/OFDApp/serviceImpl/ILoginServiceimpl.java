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
		if(loginRepo.findByPassword(login.getPassword())!=null && loginRepo.findByUserName(login.getUserName())!=null)
			return login;
		else
			return null;
	}

	@Override
	public Login signOut(Login login) {
		if(loginRepo.findByPassword(login.getPassword())!=null && loginRepo.findByUserName(login.getUserName())!=null)
			return login;
		else
			return null;
	}

	@Override
	public Login register(Login login) {
		if(loginRepo.findByUserName(login.getUserName())!=null)
			return null;
		else	{
			loginRepo.save(login);
			return login;
		}
	}

	@Override
	public List<Login> getAll() {
		return loginRepo.findAll();
	}
	
	@Override
	public Login deleteAcc(Login login)	{
//		Optional<Login> l=loginRepo.findById(login.getId());
//		Login log=null;
//		if(l.isPresent())
//			log=l.get();
//		loginRepo.delete(log);
		if(loginRepo.existsById(login.getId()))
		{
			loginRepo.delete(login);
			return login;
		}
		else
			return null;
	}
	
	@Override
	public Long getCountofUsers()	{
		return loginRepo.count();
	}
	
	@Override
	public boolean isSignedIn(Login login)	{
		if(login.isSignedIn()==1)
			return true;
		else
			return false;
	}
}
