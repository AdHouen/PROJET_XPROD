package com.xprod.spring.xprod.ressource;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/user")
@CrossOrigin("*")
public class UserResource {
	
	
	@GetMapping("/home")
	public String showUser() {
		return "application works !" ;
	}

}
