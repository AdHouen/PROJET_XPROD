package com.xprod.spring.xprod.service.impl;


import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.xprod.spring.xprod.domain.User;
import com.xprod.spring.xprod.domain.UserPrincipal;
import com.xprod.spring.xprod.exception.domain.EmailExistException;
import com.xprod.spring.xprod.exception.domain.UserNotFoundException;
import com.xprod.spring.xprod.exception.domain.UsernameExistException;
import com.xprod.spring.xprod.repository.IUserRepository;
import com.xprod.spring.xprod.service.IUserService;

import jakarta.transaction.Transactional;

import static com.xprod.spring.xprod.enumeration.Role.*;


@Service
@Transactional
@Qualifier("UserDetailsService")
public class UserServiceImpl implements IUserService, UserDetailsService{
	

	private Logger LOGGER = LoggerFactory.getLogger(getClass());
	private IUserRepository iUserRepository;
	private BCryptPasswordEncoder passwordEncoder;
	

	@Autowired
	public UserServiceImpl(IUserRepository iUserRepository, BCryptPasswordEncoder passwordEncoder) {
		super();
		this.iUserRepository = iUserRepository;
		this.passwordEncoder = passwordEncoder;
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
	// Ajoute également un objet utilisateur dans la base de données, réserver au front office elle est destinée 
	// à l'ajout d'un utilisateur lorsqu'un utilisateur créé un compte dans l'application
	@Override
	public User register(String firstName, String lastName, String username, String email) {
		try {
			validatedNewUsernameAndEmail(StringUtils.EMPTY, username,email);
			
			User user = new User();
			
			user.setIdUser(generateUserId());
			String password = generatePassword();
			String encodedPassword = encodePassword(password);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setUsername(username);
			user.setEmail(email);
			user.setJoinDate(new Date());
			user.setPassword(encodedPassword);
			user.setActive(true);
			user.setNotLocked(true);
			user.setRole(ROLE_USER.name());
			user.setAuthorities(ROLE_USER.getAuthorities());
			user.setProfileImageURL(getTemporaryProfilImageUrl());
			
			iUserRepository.save(user);
			LOGGER.info("New user password : "+password);
			
		} catch (UserNotFoundException | UsernameExistException |EmailExistException e) {
			
			e.printStackTrace();
		
		}
		return null;
	}

	private String getTemporaryProfilImageUrl() {
		
		return ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/image/profile/temp").toString();
	}

	private String encodePassword(String password) {
		
		return passwordEncoder.encode(password);
	}

	private String generatePassword() {
		
		return RandomStringUtils.randomAlphanumeric(10);
	}

	private String generateUserId() {
		
		return RandomStringUtils.randomNumeric(10);
	}

	// validateNewUsernameAndEmail() est appelé par validateNewUsernameAndEmail() et register()
	// elle vérifie si les valeurs Username et Email appartiennent déjà à un utlisateur 
	private User validatedNewUsernameAndEmail(String currentUsername, String newUsername, String newEmail) throws UserNotFoundException, UsernameExistException, EmailExistException  {
		
		User userNewByUsername = findUserByUsername(newUsername);
		User userNewByEmail = findUserByEmail(newEmail);
		
		
		if(StringUtils.isNotBlank(currentUsername)) {
			
			User currentUser = findUserByUsername(currentUsername);
			if (currentUser == null) {
				throw new UserNotFoundException("Pas d'utilisateur trouvé avec cet username" + currentUsername);
				
			}
			
			
			if (userNewByUsername != null && currentUser.getId().equals(userNewByUsername.getId())) {
				throw new UsernameExistException("L'username existe déjà");
				
			}
			
			
			if (userNewByEmail != null && currentUser.getId().equals(userNewByEmail.getId())) {
				throw new EmailExistException("Un utilisateur avec cette adresse mail exist déjà");
				
			}
			
			return currentUser; 
		
		}else {
			
			if (userNewByUsername != null ) {
				throw new UsernameExistException("L'username existe déjà" + userNewByUsername );
				
			}
			
			
			if (userNewByEmail != null ) {
				throw new EmailExistException("Un utilisateur avec cette adresse mail exist déjà" + userNewByEmail);
				
			}
			return null;
			
		}
		
		
	}



	@Override
	public List<User> getUsers() {
		return  iUserRepository.findAll();
	}



	@Override
	public User findUserByUsername(String username) {
		return iUserRepository.findUserByUsername(username);
	}



	@Override
	public User findUserByEmail(String email) {
		return iUserRepository.findUserByEmail(email);
	}
	
	

}
