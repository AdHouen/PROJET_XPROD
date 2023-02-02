package com.xprod.spring.xprod.service.impl;


import java.util.Date;
import java.util.List;

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
import com.xprod.spring.xprod.exception.domain.EmailExistException;
import com.xprod.spring.xprod.exception.domain.UserNotFoundException;
import com.xprod.spring.xprod.exception.domain.UsernameExistException;
import com.xprod.spring.xprod.repository.IUserRepository;
import com.xprod.spring.xprod.service.IUserService;

import io.micrometer.common.util.StringUtils;
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



	@Override
	public User register(String firstName, String lastName, String username, String email) {
		validatedNewUsernameAndEmail();
		return null;
	}



	private User validatedNewUsernameAndEmail(String currentUsername, String newUsername, String newEmail) throws UserNotFoundException, UsernameExistException, EmailExistException  {
		
		
		if(StringUtils.isNotBlank(currentUsername)) {
			
			User currentUser = findUserByUsername(currentUsername);
			
			if (currentUser == null) {
				throw new UserNotFoundException("Pas d'utilisateur trouvé avec cet username" + currentUsername);
				
			}
			
			User userByUsername = findUserByUsername(newUsername);
			if (userByUsername != null && currentUser.getId().equals(userByUsername.getId())) {
				throw new UsernameExistException("L'username existe déjà");
				
			}
			
			User userByEmail = findUserByEmail(newEmail);
			if (userByEmail != null && currentUser.getId().equals(userByEmail.getId())) {
				throw new EmailExistException("Un utilisateur avec cette adresse mail exist déjà");
				
			}
			
			return currentUser; 
		
		}
		
			
		
	}



	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User findUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
