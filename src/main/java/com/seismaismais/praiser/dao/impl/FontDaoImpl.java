package com.seismaismais.praiser.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.seismaismais.praiser.dao.FontDao;
import com.seismaismais.praiser.model.Font;

@Repository("fontDao")
public class FontDaoImpl implements FontDao {

	private final SessionFactory sessionFactory;

	@Autowired
	public FontDaoImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Font> list() {
		List<Font> list = null;
		try {
			list = sessionFactory.getCurrentSession().createCriteria(Font.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Transactional(readOnly = true)
	@Override
	public Font findById(Long id) {
		Font font = null;
		try {
			font = sessionFactory.getCurrentSession().get(Font.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return font;
	}
	
	@Transactional(readOnly = true)
	@Override
	public Font findByFilename(String filename) {
		Font font = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery("from Font s where s.filename = :filename");
			query.setParameter("filename", filename);
			font = (Font) query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return font;
	}

	@Transactional
	@Override
	public void delete(Font u) {
		try {
			sessionFactory.getCurrentSession().delete(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void create(Font u) {
		try {
			sessionFactory.getCurrentSession().save(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void update(Font u) {
		try {
			sessionFactory.getCurrentSession().update(u);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}