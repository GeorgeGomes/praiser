package com.seismaismais.praizer.auth.service;

import org.springframework.security.core.AuthenticationException;

import com.seismaismais.praizer.auth.model.User;

public interface AuthenticateService {

	public User authenticate(String email, String password) throws AuthenticationException;
}