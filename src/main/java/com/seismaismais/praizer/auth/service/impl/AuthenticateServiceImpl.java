package com.seismaismais.praizer.auth.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

import com.seismaismais.praizer.auth.model.User;
import com.seismaismais.praizer.auth.service.AuthenticateService;
import com.seismaismais.praizer.auth.service.UserService;

@Service("authenticateService")
public class AuthenticateServiceImpl implements  AuthenticateService{
	
	@Autowired
	private UserService userService;
	
	public User authenticate(String email, String password) throws AuthenticationException {
		User user = (User) userService.findByEmail(email);
		
		if (user == null || !user.getEmail().equalsIgnoreCase(email)) {
			user = null;
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			user = null;
			throw new BadCredentialsException("Wrong password.");
		}

		Authentication auth = new UsernamePasswordAuthenticationToken(email, password, userService.getGrantedAuthorities(user));
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		return user;
	}
}
