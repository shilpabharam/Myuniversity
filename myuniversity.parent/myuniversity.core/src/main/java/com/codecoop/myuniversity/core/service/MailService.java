package com.codecoop.myuniversity.core.service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(MailService.class);
	
	 @Autowired
	 private MailSender mailSender;
	
	 @Autowired
	 private JavaMailSender javaMailSender;
	/**
	 * This method will send compose and send the message 
	 * */
	public void sendMail(String subject, String body, String reciver, String from) 
	{
		try{
			SimpleMailMessage message = new SimpleMailMessage(); 
			//	        String[] toArray =  new String[]{"thisisram@gmail.com", "jagadeesh.subha@gmail.com"};
			//	        message.setTo(toArray);
			message.setFrom(from);
			message.setTo(reciver);
			message.setSubject(subject);
			message.setText(body);
			mailSender.send(message);
		}
		catch(Exception e){
			System.out.println("error"+e);
		}
	}

	public void sendMailHtml(final String subject, final String body, final String reciver, final String from) throws MessagingException {  
        
		MimeMessage message = javaMailSender.createMimeMessage();  
		  
        MimeMessageHelper helper = new MimeMessageHelper(message, true);  
        helper.setFrom(from);  
        helper.setTo(reciver);  
        helper.setSubject(subject);  
        helper.setText(body,true);  
  
        javaMailSender.send(message);  
		
    }  
}
