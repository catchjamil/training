package guiPack;

import java.util.*;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
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

public class SendMailUsingAttachment {

    private String SMTP_HOST_NAME = "";
    private String SMTP_AUTH_USER = "";
    private String SMTP_AUTH_PWD = "";
    private String[] attachmentsPath;
    private String[] attachmentsName;

    public SendMailUsingAttachment(String SMTP_AUTH_USER, String SMTP_AUTH_PWD, String SMTP_HOST_NAME, String[] attname, String[] attPath) {
        this.SMTP_AUTH_USER = SMTP_AUTH_USER;
        this.SMTP_AUTH_PWD = SMTP_AUTH_PWD;
        this.SMTP_HOST_NAME = SMTP_HOST_NAME;
        this.attachmentsName = attname;
        this.attachmentsPath = attPath;

    }

    public void postMail(String recipients[], String subject, String message, String from) throws MessagingException {
        boolean debug = false;

        //Set the host smtp address
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.net4india.com");

        Authenticator auth = new SMTPAuthenticator();
        Session session = Session.getDefaultInstance(props, auth);

        session.setDebug(debug);

        // create a message
        Message msg = new MimeMessage(session);

        // set the from and to address
        InternetAddress addressFrom = new InternetAddress(from);
        msg.setFrom(addressFrom);

        InternetAddress[] addressTo = new InternetAddress[recipients.length];
        for (int i = 0; i < recipients.length; i++) {
            addressTo[i] = new InternetAddress(recipients[i]);
        }
        msg.setRecipients(Message.RecipientType.BCC, addressTo);
        // Setting the Subject and Content Type
        msg.setSubject(subject);

        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(message);
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        for (int i = 0; i < attachmentsName.length; i++) {
            messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachmentsPath[i]);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(attachmentsName[i]);
            multipart.addBodyPart(messageBodyPart);
        }
        msg.setContent(multipart);
        
        Transport.send(msg);
    }

    private class SMTPAuthenticator extends javax.mail.Authenticator {

        public PasswordAuthentication getPasswordAuthentication() {
            String username = SMTP_AUTH_USER;
            String password = SMTP_AUTH_PWD;
            return new PasswordAuthentication(username, password);
        }
    }
}
