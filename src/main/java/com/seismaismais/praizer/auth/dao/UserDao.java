package com.seismaismais.praizer.auth.dao;

import com.seismaismais.praizer.auth.model.User;

public interface UserDao {

	User findById(int id);
	
	User findByEmail(String email);
	
}

