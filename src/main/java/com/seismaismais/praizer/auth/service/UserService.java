package com.seismaismais.praizer.auth.service;

import com.seismaismais.praizer.auth.model.User;

public interface UserService {

	User findById(int id);
	
	User findByEmail(String email);
	
}