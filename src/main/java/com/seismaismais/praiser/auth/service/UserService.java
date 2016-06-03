package com.seismaismais.praiser.auth.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.seismaismais.praiser.auth.model.User;

public interface UserService {

	public User findById(Long id);
	public User findByEmail(String email);
	public List<User> list();
	public void delete(User user);
	public void update(User user);
	public void create(User user);
	public List<GrantedAuthority> getGrantedAuthorities(User user);
	
}