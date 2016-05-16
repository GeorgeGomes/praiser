package com.seismaismais.praizer.auth.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.seismaismais.praizer.auth.model.User;

public interface UserService {

	User findById(Long id);
	User findByEmail(String email);
	public List<User> list();
	public void delete(User user);
	public void update(User user);
	public void create(User user);
	public List<GrantedAuthority> getGrantedAuthorities(User user);
	
}