package com.xprod.spring.xprod.service.impl;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.xprod.spring.xprod.domain.User;
import com.xprod.spring.xprod.domain.UserPrincipal;
import com.xprod.spring.xprod.repository.IUserRepository;
import com.xprod.spring.xprod.service.IUserService;

import jakarta.transaction.Transactional;


@Service
@Transactional
@Qualifier("UserDetailsService")
public class UserServiceImpl implements IUserService, UserDetailsService{
	
	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private IUserRepository iUserRepository;
	
	
	@Autowired
	public UserServiceImpl(IUserRepository iUserRepository) {
		super();
		this.iUserRepository = iUserRepository;
	}



	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user  = iUserRepository.findUserByUsername(username); 
		if (user == null) {
			LOGGER.error("User not found by username" + username);
			throw new UsernameNotFoundException("User not found by username" + username);
			
		}else {
			user.setLastLoginDateDisplay(user.getLastLoginDate());
			user.setLastLoginDate(new Date());
			iUserRepository.save(user);
			UserPrincipal userPrincipal = new UserPrincipal(user);
			LOGGER.info("Returning : trouver l'utilisateur par l'username : " + username);
			return userPrincipal;
			
		}
		
		
	}
	
	

}
