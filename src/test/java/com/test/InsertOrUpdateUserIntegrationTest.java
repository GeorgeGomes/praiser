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
public class InsertOrUpdateUserIntegrationTest {

	@Autowired
	//private UserDAO usuarioDAO;

	@Test
	public void InsertOrUpdateUser() {

//		 User usuario = new User(); 
//		 Role autorizacao1 = new Role();
//		 
//		 autorizacao1.setIdRole(1L);
//		 autorizacao1.setName("ADMIN");
//		 
//		 Role autorizacao2 = new Role();
//		 
//		 autorizacao2.setIdRole(2L);
//		 autorizacao2.setName("SUPER");
//		 
//		 Role autorizacao3 = new Role();
//		 
//		 autorizacao3.setIdRole(3L);
//		 autorizacao3.setName("CONTROL");
//		 
//		 List<Role> list = new ArrayList<Role>();
//		 list.add(autorizacao1);
//		 list.add(autorizacao2);
//		 list.add(autorizacao3);
//		 
//		 //usuario.setIdUser(1L);
//		 usuario.setRoles(list); 
//		 usuario.setEnable(true);
//		 usuario.setPassword("shincansen@20");
//		 usuario.setUsername("george.gomes");
//
//		 usuarioDAO.saveOrUpdate(usuario);

	}

}
