package com.seismaismais.stronger.service;

import java.util.List;

import com.seismaismais.stronger.model.User;

public interface UserService {
	public List<User> list();
	public User get(Long id);
	public void delete(User user);
	public void update(User user);
	public void create(User user);
	
}
