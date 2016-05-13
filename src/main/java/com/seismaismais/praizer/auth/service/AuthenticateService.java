package com.seismaismais.praizer.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service("authenticateService")
public class AuthenticateService {
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService customUserDetailsService;
	
	public void authenticate(String email, String password) throws AuthenticationException {
		UserDetails userDetails = customUserDetailsService.loadUserByUsername(email);

		if (userDetails == null || !userDetails.getUsername().equalsIgnoreCase(email)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(userDetails.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		Authentication auth = new UsernamePasswordAuthenticationToken(email, password, userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(auth);
	}
}
