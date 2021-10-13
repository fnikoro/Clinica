package com.jaba37.clinicaNNMM.util;

import org.springframework.stereotype.Component;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Component
public class MailSenderComponent {

    private final static String SMTP_HOST = "smtp.gmail.com";
    private final static String SMTP_PORT = "587";
    private final static String SMTP_AUTH = "true";
    private final static String SMTP_USER = "teamclinica.jaba37@gmail.com";
    private final static String SMTP_PWD = "1C4R0_TR4N$UM4N";

    public void send(String destinatario, String oggetto, String messaggio){
        try {
            InternetAddress address = new InternetAddress(destinatario);
            Properties props = new Properties();
            props.put("mail.smtp.host", SMTP_HOST);
            props.put("mail.smtp.auth", SMTP_AUTH);
            props.put("mail.smtp.port", SMTP_PORT);
            props.put("mail.smtp.starttls.enable", "true");
            Authenticator auth = new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SMTP_USER, SMTP_PWD);
                }
            };
            Session session = Session.getDefaultInstance(props, auth);
            Message msg = new MimeMessage(session);
            InternetAddress addressFrom = new InternetAddress(SMTP_USER);
            msg.setFrom(addressFrom);
            msg.setRecipient(Message.RecipientType.TO, address);
            msg.setSubject(oggetto);
            msg.setText(messaggio);
            Transport.send(msg);
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}