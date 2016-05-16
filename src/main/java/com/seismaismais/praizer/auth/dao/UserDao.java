package com.seismaismais.praizer.auth.dao;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.seismaismais.praizer.auth.model.User;

public interface UserDao {
	public User findById(Long id);
	public User findByEmail(String email);
	public void create(User user); 
	public void update(User user);
	public void delete(User user);
	public List<User> list();
	public List<GrantedAuthority> getGrantedAuthorities(User user);
	
}

