package com.ts1.dao;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {
	public static void sendMail(String email, String msg, String sub) {
		final String username = "pickabook1234@gmail.com";
		final String password = "pickabook";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.pool", "true");
		
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
		});
		
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pickabook1234@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject(sub);
			message.setText(msg);
			
			Transport.send(message);
			System.out.println("msg sent");
		}
		catch(MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

	public static void main(String[] args) {
		
		final String username = "pickabook1234@gmail.com";
		final String password = "pickabook";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.pool", "true");
		
		
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(username, password);
					}
		});
		
		try {
			//Session.getDefaultInstance(props);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("pickabook1234@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("manasachepuri2000@gmail.com"));
			message.setSubject("Test");
			message.setText("Hello");
			
			Transport.send(message);
			System.out.println("msg sent");
		}
		catch(MessagingException e) {
			throw new RuntimeException(e);
		}
		
	}

}
