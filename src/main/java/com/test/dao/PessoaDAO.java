package com.test.dao;

import java.util.List;

import com.test.model.Pessoa;

public interface PessoaDAO {
	public void saveOrUpdate(Pessoa pessoa); 
	public void delete(Pessoa pessoa);
	public Pessoa findById(Long id); 
	public List<Pessoa> getList();
}
