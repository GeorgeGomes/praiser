package com.seismaismais.praiser.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praiser.dao.BackgroundDao;
import com.seismaismais.praiser.model.Background;

@Repository("backgroundDao")
public class BackgroundDaoImpl implements BackgroundDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public BackgroundDaoImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Background> list() {
		List<Background> list = null;
		try {
			list = sessionFactory.getCurrentSession().createCriteria(Background.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public Background findById(Long id) {
		Background background = null;
		try {
			background = sessionFactory.getCurrentSession().get(Background.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return background;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Background findByFilename(String filename) {
		Background background = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Background s where s.filename = :filename");
			query.setParameter("filename", filename);
			background = (Background) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return background;
	}

	@Transactional
	@Override
	public void delete(Background u) {
		try {
			sessionFactory.getCurrentSession().delete(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void create(Background u) {
		try {
			sessionFactory.getCurrentSession().save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void update(Background u) {
		try {
			sessionFactory.getCurrentSession().update(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}