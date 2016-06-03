package com.seismaismais.praiser.auth.service;

import org.springframework.security.core.AuthenticationException;

import com.seismaismais.praiser.auth.model.User;

public interface AuthenticateService {
	public User authenticate(String email, String password) throws AuthenticationException;
	public void logout();
	public void saveUserRequest(User user);
	public User getUserRequest();
	public void removeUserRequest();
}