package com.xprod.spring.xprod.ressource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xprod.spring.xprod.exception.domain.EmailExistException;
import com.xprod.spring.xprod.exception.domain.ExceptionHandling;

@RestController
@RequestMapping("/user")
public class UserResource extends ExceptionHandling{
	
	
	@GetMapping("/home")
	public String showUser() throws EmailExistException{
//		return "application works !" ;
		throw new EmailExistException("Cette adresse email est déjà prise ! ");
	}

}
