package com.yummyBites.services;

import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;


import org.springframework.stereotype.Service;


@Service
public class EmailService {
	


	
	public boolean sendEmail(String subject,String message,String to) {
		boolean f=false;
		String from="piyushgupta44444@gmail.com";
		
		Properties properties=new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.starttls.enable", true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		
		String username="piyushgupta44444";
		String password="grclqzsmylgwtrfg";
		Session session=Session.getInstance(properties,new Authenticator(){

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
			});
		try {
			System.out.println("i m in");
			Message message2=new MimeMessage(session);
			message2.setFrom(new InternetAddress(from));
			message2.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message2.setText(message);
			message2.setSubject(subject);
			Transport.send(message2);
			f=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
