package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:**/spring-database-test.xml" })
@Transactional
public class InsertOrUpdateRoleIntegrationTest {

	@Autowired
	//private RoleDAO autorizacaoDAO;

	@Test
	public void InsertOrUpdateRole(){
	
//		Role autorizacao = new Role();
//		autorizacao.setName("ADMIN");
//		autorizacaoDAO.saveOrUpdate(autorizacao);
//		
//		autorizacao = new Role();
//		autorizacao.setName("SUPER");
//		autorizacaoDAO.saveOrUpdate(autorizacao);
//		
//		autorizacao = new Role();
//		autorizacao.setName("CONTROL");
//		autorizacaoDAO.saveOrUpdate(autorizacao);
//		
//		autorizacao = new Role();
//		autorizacao.setName("TOP");
//		autorizacaoDAO.saveOrUpdate(autorizacao);
		
	}

}
