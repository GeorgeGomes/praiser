package com.seismaismais.stronger.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.stronger.dao.MuscleGroupDAO;
import com.seismaismais.stronger.model.MuscleGroup;

@Repository("muscleGroupDAO")
public class MuscleGroupDAOImpl implements MuscleGroupDAO {

	
	private final SessionFactory sessionFactory;
	
	@Autowired
	public MuscleGroupDAOImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<MuscleGroup> list() {
		List<MuscleGroup> list = null;
		try {
			list = sessionFactory.getCurrentSession().createCriteria(MuscleGroup.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public MuscleGroup get(Long id) {
		MuscleGroup register = null;
		try {
			register = sessionFactory.getCurrentSession().get(MuscleGroup.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return register;
	}

	@Transactional
	@Override
	public void delete(MuscleGroup muscleGroup) {
		try {
			sessionFactory.getCurrentSession().delete(muscleGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void create(MuscleGroup muscleGroup) {
		try {
			sessionFactory.getCurrentSession().save(muscleGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional
	@Override
	public void update(MuscleGroup muscleGroup) {
		try {
			sessionFactory.getCurrentSession().update(muscleGroup);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}