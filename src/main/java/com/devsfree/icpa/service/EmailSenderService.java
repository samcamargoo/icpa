package com.devsfree.icpa.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * @author Samuel
 *
 */

@Service
public class EmailSenderService {

	@Autowired
	private JavaMailSender mailSender;
	
	@Async
	public void enviarEmailParaAlterarSenha(String destinatario, String mensagem) {
		
		MimeMessage mailMessage = mailSender.createMimeMessage();
		try {
			mailMessage.setSubject("Redefina sua senha", "UTF-8");
			MimeMessageHelper helper = new MimeMessageHelper(mailMessage, true, "UTF-8");
			helper.setFrom("naoresponda@chamadosparaadorar.com.br");
			helper.setTo(destinatario);
			helper.setText(buildEmail(mensagem), true);

			mailSender.send(mailMessage);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private String buildEmail(String mensagem) {
		return "<p>Para alterar sua senha clique no link abaixo, o link tem validade de 15 minutos! </p>" + "\n " + mensagem; 
				
	}
}
