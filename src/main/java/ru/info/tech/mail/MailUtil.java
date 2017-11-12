package ru.info.tech.mail;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Sulaymon on 05.11.2017.
 */
public class MailUtil {
    private Logger log = Logger.getLogger(MailUtil.class);
    private Properties properties;

    public MailUtil() {
        this.properties = new Properties();
    }

    private Properties getProperties() {
        try {
            properties.load(MailUtil.class.getClassLoader().getResourceAsStream("email.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            log.info("Properties file NOT FOUND!");
        }
        return properties;
    }

    public void mailConfig(String mailTo, String url){
        Session mailSession = Session.getDefaultInstance(getProperties());
        MimeMessage message = new MimeMessage(mailSession);

        String userMail = properties.getProperty("mail.smtps.user");
        String password = properties.getProperty("mail.smpts.password");

        try {
            message.setFrom(new InternetAddress(userMail));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
            message.setSubject("From medical insurance company");

            Multipart multipart = new MimeMultipart();
            BodyPart htmlBodyPart = new MimeBodyPart();
            String htmlMessageAsString = "<h2>Здравствуйте!<br/><hr>" +
                    " Недавно вы создали аккаунт на сайте MIC.<br/> Подтвердите его, чтобы завершить регистрацию.</h2><br/>" +
                    " <a href='"+url+"'>"+url+"</a>";
            htmlBodyPart.setContent(htmlMessageAsString,"text/html; charset=UTF-8");
            multipart.addBodyPart(htmlBodyPart);
            message.setContent(multipart);

            Transport transport = mailSession.getTransport();
            transport.connect(userMail, password);
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
            log.info("Message not sent! Error");
        }
    }
}
