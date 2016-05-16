package com.seismaismais.praizer.auth.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praizer.auth.dao.UserDao;
import com.seismaismais.praizer.auth.model.User;
import com.seismaismais.praizer.auth.model.UserProfile;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public UserDaoImpl(final SessionFactory sessionFactory) {
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
	public User findById(Long id) {
		User user = null;
		try {
			user = sessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public User findByEmail(String email) {
		User user = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
			criteria.add(Restrictions.eq("email", email));
			user = (User) criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Transactional
	@Override
	public void delete(User u) {
		try {
			sessionFactory.getCurrentSession().delete(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void create(User u) {
		try {
			sessionFactory.getCurrentSession().save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void update(User u) {
		try {
			sessionFactory.getCurrentSession().update(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (UserProfile userProfile : user.getUserProfiles()) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + userProfile.getType()));
		}
		return authorities;
	}

}