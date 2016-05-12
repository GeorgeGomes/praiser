package com.seismaismais.praizer.auth.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praizer.auth.dao.UserDao;
import com.seismaismais.praizer.auth.model.User;
import com.seismaismais.praizer.auth.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDAO;

	public User findById(Long id) {
		return userDAO.findById(id);
	}

	public User findByEmail(String email) {
		return userDAO.findByEmail(email);
	}
	
	public List<User> list() {
		return userDAO.list();
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