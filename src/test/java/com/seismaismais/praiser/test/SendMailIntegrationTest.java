package com.seismaismais.praiser.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.test.util.mail.MailTemplate;
import com.test.util.mail.SendMailAuth;
import com.test.util.mail.domain.MailMessage;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring-database-test.xml"})
public class SendMailIntegrationTest {

	@Autowired
	private SendMailAuth sendMailAuth;
	
	@Test
	public void SendMail() {
		try {
			
			MailMessage message = new MailMessage();
			message.setFrom("george.gomes@hotmail.com");
			message.setPersonal("george.gomes@hotmail.com");
			message.setTo("george.gomes@pellegrino.com.br");
			message.setSubject("assunto");
			message.setText("teste");
			
			//TEMPLATE VELOCITY
	        Map<String, Object> modelVelocity = new HashMap<String, Object>();
	        modelVelocity.put("name", "George");
	        modelVelocity.put("link", "http://www.google.com.br");
			
			sendMailAuth.sendMail(message, MailTemplate.FORGOT_PASSWORD, modelVelocity);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
