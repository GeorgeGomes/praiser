package com.test.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.test.dao.PessoaDAO;
import com.test.model.Pessoa;

@Repository("pessoaDAO")
public class PessoaDAOImpl implements PessoaDAO {

	private final SessionFactory sessionFactory;

	@Autowired
	public PessoaDAOImpl(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	@Override
	public List<Pessoa> getList() {
		List<Pessoa> pessoaList = null;
		try {
			pessoaList = sessionFactory.getCurrentSession().createCriteria(Pessoa.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoaList;
	}

	@Transactional(readOnly = true)
	@Override
	public Pessoa findById(Long id) {
		Pessoa pessoa = null;
		try {
			pessoa = sessionFactory.getCurrentSession().get(Pessoa.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pessoa;
	}

	@Transactional
	@Override
	public void delete(Pessoa p) {
		try {
			sessionFactory.getCurrentSession().delete(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Transactional
	@Override
	public void saveOrUpdate(Pessoa p) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}