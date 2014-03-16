package com.sd.training.struts2.util;

import java.security.Security; 
 
import java.util.Properties;  

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;  
import javax.mail.MessagingException;  
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;  
import javax.mail.Session;  
import javax.mail.Transport;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;  
import javax.mail.internet.MimeMultipart;
  


	public class SendEmail {  
		  
	    private static final String SMTP_HOST_NAME = "smtp.gmail.com";  
	    private static final String SMTP_PORT = "465";  
	    private static final String emailFromAddress = "javaworkspace@gmail.com"; 
	    private static final String emailPassword = "password"; 
	    private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";  
	    private String[] attachmentsPath;
	    private String[] attachmentsName;
	    public  void SendEmail(String emailSubjectTxt,String emailMsgTxt,String[] sendTo,String[] attachmentsName, String[] attachmentsPath ) throws Exception {  
	  try{
		  this.attachmentsName = attachmentsName;
		  this.attachmentsPath = attachmentsPath;
	        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());  
	        SendEmail sendMailThroughJava = new SendEmail();  
	        sendMailThroughJava.sendSSLMessage(sendTo, emailSubjectTxt,  
	                emailMsgTxt, emailFromAddress);  
	        System.out.println("Sucessfully sent mail to all Users");  
	  }catch(Exception e){
		  e.printStackTrace();
	  }
	    }  
	  
	    /** 
	     * @param recipients 
	     * @param subject 
	     * @param message 
	     * @param from 
	     * @throws MessagingException 
	     */  
	    public void sendSSLMessage(String recipients[], String subject,  
	            String message, String from) throws MessagingException {  
	        boolean debug = true;  
	  
	        Properties props = new Properties();  
	        props.put("mail.smtp.host", SMTP_HOST_NAME);  
	        props.put("mail.smtp.auth", "true");  
	        props.put("mail.debug", "true");  
	        props.put("mail.smtp.port", SMTP_PORT);  
	        props.put("mail.smtp.socketFactory.port", SMTP_PORT);  
	        props.put("mail.smtp.socketFactory.class", SSL_FACTORY);  
	        props.put("mail.smtp.socketFactory.fallback", "false");  
	  
	        Session session = Session.getDefaultInstance(props,  
	                new javax.mail.Authenticator() {  
	                    protected PasswordAuthentication getPasswordAuthentication() {  
	                        return new PasswordAuthentication(emailFromAddress,  
	                                emailPassword);  
	                    }  
	                });  
	  
	        session.setDebug(debug);  
	  
	        Message msg = new MimeMessage(session);  
	        InternetAddress addressFrom = new InternetAddress(from);  
	        msg.setFrom(addressFrom);  
	  
	        InternetAddress[] addressTo = new InternetAddress[recipients.length];  
	        for (int i = 0; i < recipients.length; i++) {  
	            addressTo[i] = new InternetAddress(recipients[i]);  
	        }  
	        msg.setRecipients(Message.RecipientType.TO, addressTo);  
	  
	        // Setting the Subject and Content Type  
	        msg.setSubject(subject);  
	        
	        BodyPart messageBodyPart = new MimeBodyPart();
	        messageBodyPart.setText(message);
	        Multipart multipart = new MimeMultipart();
	        multipart.addBodyPart(messageBodyPart);
	        if(attachmentsName != null){
		        for (int i = 0; i < attachmentsName.length; i++) {
		            messageBodyPart = new MimeBodyPart();
		            DataSource source = new FileDataSource(attachmentsPath[i]);
		            messageBodyPart.setDataHandler(new DataHandler(source));
		            messageBodyPart.setFileName(attachmentsName[i]);
		            multipart.addBodyPart(messageBodyPart);
		        }
	        }
	        
	        
	        msg.setContent(multipart);  
	       
	        Transport.send(msg);  
	    }  
	}  	
	

