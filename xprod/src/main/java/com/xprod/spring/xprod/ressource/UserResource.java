package com.xprod.spring.xprod.ressource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xprod.spring.xprod.domain.User;
import com.xprod.spring.xprod.exception.domain.EmailExistException;
import com.xprod.spring.xprod.exception.domain.ExceptionHandling;
import com.xprod.spring.xprod.service.IUserService;

@RestController
@RequestMapping(path = {"/","/user"})
public class UserResource extends ExceptionHandling{
	
	private IUserService iUserService;
	
	@Autowired
	public UserResource(IUserService iUserService) {
		super();
		this.iUserService = iUserService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<User> register(@RequestBody User user) {
		
		User newUser = iUserService.register(user.getFirstName(),user.getLastName(), user.getUsername(), user.getEmail());
		
		return new ResponseEntity<>(newUser, HttpStatus.OK);
		
	}
	
	
	
//	@GetMapping("/home")
//	public String showUser() throws EmailExistException{
////		return "application works !" ;
//		throw new EmailExistException("Cette adresse email est déjà prise ! ");
//	}
	
	

}
