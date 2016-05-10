package com.seismaismais.stronger.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seismaismais.stronger.dao.UserDAO;
import com.seismaismais.stronger.model.User;
import com.seismaismais.stronger.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO;

	public List<User> list() {
		return userDAO.list();
	}

	public User get(Long id) {
		return userDAO.get(id);
	}

	public void delete(User user) {
		userDAO.delete(user);
	}

	public void create(User user) {
		userDAO.create(user);
	}
	
	public void update(User user) {
		userDAO.update(user);
	}

}