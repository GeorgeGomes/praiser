package com.test.util.mail;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.messaging.MessagingException;
import org.springframework.stereotype.Component;

import com.test.util.mail.domain.MailMessage;

@Component("sendMailAuth")
public class SendMailAuth {
	
	@Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private VelocityService velocityService;
	
    public void sendMail(MailMessage message, MailTemplate mailTemplate, Map<String, Object> modelVelocity) throws javax.mail.MessagingException {
        Date date = new Date();

        message.setFrom( ((JavaMailSenderImpl) javaMailSender).getUsername() );

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        velocityService.setModel(modelVelocity);

        try {
            helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(message.getFrom(), message.getPersonal());
            helper.setTo(message.getTo());
            helper.setSentDate(date);
            helper.setText(velocityService.getVelocityBody(mailTemplate.getValue()), true);
            helper.setSubject(message.getSubject());

            for (String anexo : message.getAttachments()) {
                File attach = new File(anexo);
                helper.addAttachment("Attachment: " + attach.getName(), attach);
            }

            javaMailSender.send(mimeMessage);
            System.out.println("Envio com Sucesso!");
        } catch (MailException e) {
            System.out.println("Email n&atilde;o pode ser eviado!n" + e.getMessage());
        } catch (MessagingException e) {
            System.out.println("Email n&atilde;o pode ser eviado.n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Anexo n&atilde;o encontradon" + e.getMessage());
        }
    }
    	
}
