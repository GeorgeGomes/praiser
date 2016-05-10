package com.seismaismais.stronger.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.stronger.dao.UserDAO;
import com.seismaismais.stronger.model.User;

@Repository("userDAO")
public class UserDAOImpl implements UserDAO {

	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public UserDAOImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() {
		List<User> list = null;
		try {
			list = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public User get(Long id) {
		User register = null;
		try {
			register = sessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return register;
	}

	@Transactional
	@Override
	public void delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void create(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public void update(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}