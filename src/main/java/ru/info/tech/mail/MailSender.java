package ru.info.tech.mail;

/**
 * Created by Sulaymon on 05.11.2017.
 */
public class MailSender {
    private MailUtil mailUtil;

    public MailSender() {
        this.mailUtil = new MailUtil();
    }

    public void sendMail(String userMail, String url){
        mailUtil.mailConfig(userMail, url);
    }
}
