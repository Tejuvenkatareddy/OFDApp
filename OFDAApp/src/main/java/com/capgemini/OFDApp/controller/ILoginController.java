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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.OFDApp.domain.Login;
import com.capgemini.OFDApp.service.ILoginService;
import com.capgemini.OFDApp.serviceImpl.MapValidationErrorServiceImpl;

@RestController
@RequestMapping("/login")
public class ILoginController {
	
	@Autowired
	private ILoginService loginService;
	
	@Autowired
	private MapValidationErrorServiceImpl mapValidationService;
	
	@PostMapping("/signIn")
	public String signIn(@RequestBody Login login)	{
			if(loginService.signIn(login)==null)	{
				return "Please enter valid details";
			}
			else
			{
				if(loginService.isSignedIn(login)==true)	{
					return "You are already signed in";
				}
				else	{
					login.setSignedIn(1);
					loginService.register(login);
					return "Successfully logged in";
				}
			}
			
	}
	
	@PostMapping("/signOut")
	public String signOut(@RequestBody Login login)	{
		if(loginService.signIn(login)==null)	{
			return "Please enter valid details";
		}
		else	{
			
			return "Successfully logged out";
		}
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody Login login, BindingResult result)	{
		ResponseEntity<?> errorMap = mapValidationService.mapValidationError(result);
		if(errorMap!=null) 
			return errorMap;
		if(loginService.register(login)==null)	{
			return new ResponseEntity<>("Account already exists", HttpStatus.CONFLICT);
		}
		else	{
			return new ResponseEntity<>("Successfully created", HttpStatus.CREATED);
		}
	}
	
	@GetMapping("/showAll")
	public ResponseEntity<?> showAllLoggedIn ()	{
		return new ResponseEntity<>(loginService.getAll(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public String deleteAccount(@RequestBody Login login)	{
		if(loginService.getCountofUsers()==0)	{
			return "No users in the database";
		}
		else if(loginService.deleteAcc(login)==null)	{
			return "Account not in database";
		}
		else	{
			return "Account deleted successfully";
		}
	}
}
