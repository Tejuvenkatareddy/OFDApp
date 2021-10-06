package com.capgemini.OFDApp.service;

import java.util.List;

import com.capgemini.OFDApp.domain.Login;
/**
 * Login service interface which contains the utilities
 * @author arkap
 *
 */
public interface ILoginService {
	
	public Login signIn(Login login);
	public Login signOut(Login login);
	public Login register(Login login);
	public List<Login> getAll();
	public Login deleteAcc(Login login);
	public Long getCountofUsers();
	public boolean isSignedIn(Login login);
}
