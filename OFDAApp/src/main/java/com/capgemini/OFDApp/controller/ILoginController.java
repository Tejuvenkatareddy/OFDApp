package com.capgemini.OFDApp.controller;


/**
 * This is the Login controller using REST
 * @author Soumyadip Pal
 */
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.OFDApp.domain.Login;
import com.capgemini.OFDApp.respository.ILoginRepository;
import com.capgemini.OFDApp.service.ILoginService;
import com.capgemini.OFDApp.serviceImpl.MapValidationErrorServiceImpl;

@RestController
@RequestMapping("/login")
public class ILoginController {
	
	@Autowired
	private ILoginService loginService;
	@Autowired
	private ILoginRepository loginRepo;
	@Autowired
	private MapValidationErrorServiceImpl mapValidationService;
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody Login login)	{
			if(loginService.signIn(login)==null)	{
				return "Please enter valid details";
			}
			else	{
				return "Successfully logged in";
			}
	}
	
	@PostMapping("/signOut")
	public String signOut(@RequestBody Login login)	{
		if(login==null)	{
			return "Please enter valid details";
		}
		else if(loginRepo.count()==0)	{
			return "Already signed out";
		}
		else	{
			Login log=loginService.signOut(login);
			return "Successfully logged out\nDetails: "+log;
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody Login login, BindingResult result)	{
		ResponseEntity<?> errorMap = mapValidationService.mapValidationError(result);
		if(errorMap!=null) 
			return errorMap;
		loginService.register(login);
		return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
	}
	
	@PostMapping("/showAll")
	public ResponseEntity<?> showAllLoggedIn ()	{
		return new ResponseEntity<>(loginService.getAll(), HttpStatus.OK);
	}
}
