package com.seismaismais.stronger.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.stronger.dao.ExerciseDAO;
import com.seismaismais.stronger.model.Exercise;

@Repository("exerciseDAO")
public class ExerciseDAOImpl implements ExerciseDAO {

	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public ExerciseDAOImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Exercise> list() {
		List<Exercise> list = null;
		try {
			list = sessionFactory.getCurrentSession().createCriteria(Exercise.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public Exercise get(Long id) {
		Exercise register = null;
		try {
			register = sessionFactory.getCurrentSession().get(Exercise.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return register;
	}

	@Transactional
	@Override
	public void delete(Exercise exercise) {
		try {
			sessionFactory.getCurrentSession().delete(exercise);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void create(Exercise exercise) {
		try {
			sessionFactory.getCurrentSession().save(exercise);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public void update(Exercise exercise) {
		try {
			sessionFactory.getCurrentSession().update(exercise);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}