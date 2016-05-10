package com.test.bean;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import com.test.dao.PessoaDAO;
import com.test.model.Pessoa;

@Controller("crudBean")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class CrudBean {

	final static Logger logger = Logger.getLogger(CrudBean.class);
	
	@Autowired
	private PessoaDAO dao;
	private Pessoa pessoa = new Pessoa();
	
	public void saveOrUpdate(){
		logger.info("Chamando o m�todo: saveOrUpdate");
		logger.info("Pessoa: " + pessoa.toString());
		dao.saveOrUpdate(pessoa);
	}
	
	public void delete(){
		logger.info("Chamando o m�todo: delete");
		dao.delete(pessoa);
	}
	
	public void findById(Long id){
		logger.info("Chamando o m�todo: findById");
		this.setPessoa(dao.findById(id));
	}
	
	public List<Pessoa> getList(){
		logger.info("Chamando o m�todo: getList");
		return dao.getList();
	}

	//*** GETTERS SETTERS ***
		
	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setDao(final PessoaDAO dao) {
		this.dao = dao;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
