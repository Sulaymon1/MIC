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
/*
* it must be in resources/email.properties
*
* mail.transport.protocol=smtps
* mail.smtps.auth=true
* mail.smtps.host=smtp.gmail.com
* mail.smtps.user=medinsurancecompany@mail.ru
* mail.smpts.password=*****
*
* */

public class MailDemonstration {
    private static Logger log = Logger.getLogger(MailDemonstration.class);
    public static void main(String[] args) {
        String to = "demirel6777@gmail.com";
        String from = "medinsurancecompany@mail.ru";

        Properties properties = new Properties();
        try {

            properties.load(MailDemonstration.class.getClassLoader().getResourceAsStream("email.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            log.info("properties file not found!");
        }

        Session mailSession = Session.getDefaultInstance(properties);

        MimeMessage message = new MimeMessage(mailSession);
        try {
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is subject");
            message.setText("This is actual message");

            Multipart multipart = new MimeMultipart();
            BodyPart htmlBodyPart = new MimeBodyPart();
            String htmlMessageAsString = "<h2>Здравствуйте!<br/><hr>" +
                    " Недавно вы создали аккаунт на сайте MIC.<br/> Подтвердите его, чтобы завершить регистрацию.</h2><br/>" +
                    " <a href='#'>";
            htmlBodyPart.setContent(htmlMessageAsString,"text/html; charset=UTF-8");
            multipart.addBodyPart(htmlBodyPart);
            message.setContent(multipart);

            Transport transport = mailSession.getTransport();
            String user = properties.getProperty("mail.smtps.user");
            log.info("we got user mail "+ user);
            String password = mailSession.getProperty("mail.smpts.password");
            log.info("we got password mail "+ password);
            transport.connect(user, password);
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("Sent message successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
