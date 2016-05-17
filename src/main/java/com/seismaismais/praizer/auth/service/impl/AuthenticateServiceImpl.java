package com.seismaismais.praizer.auth.service.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.seismaismais.praizer.auth.model.User;
import com.seismaismais.praizer.auth.service.AuthenticateService;
import com.seismaismais.praizer.auth.service.UserService;

@Service("authenticateService")
public class AuthenticateServiceImpl implements  AuthenticateService{
	
	@Autowired
	private UserService userService;
	private final String OBJECT_USER_SAVED_REQUEST = "USER";
	
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
	
	public void saveObjectRequest(User user, HttpServletRequest request){
		HttpSession session = request.getSession(); 
		session.setAttribute(this.OBJECT_USER_SAVED_REQUEST, user);
	}
	
	public User getObjectRequest(HttpServletRequest request){
		HttpSession session = request.getSession(); 
		return (User) session.getAttribute(this.OBJECT_USER_SAVED_REQUEST);
	}
}
