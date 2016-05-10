package com.seismaismais.stronger.dao;

import java.util.List;

import com.seismaismais.stronger.model.User;

public interface UserDAO {
	public void create(User user); 
	public void update(User user);
	public void delete(User user);
	public User get(Long id); 
	public List<User> list();
}