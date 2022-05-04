package com.mon;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class EmailSender {

    private JavaMailSender javaMailSender;

    static final Logger log = LoggerFactory.getLogger(EmailSender.class);

    @Value("${dbdisconnection.email.from:null}")
    private String from;

    @Value("${dbdisconnection.email.to:null}")
    private String to;

    @Value("${spring.datasource.hikari.connection-timeout:0}")
    private int ms;

    EmailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    void sendEmail(String from, String subject, String text, String... to) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(text);
        try {
            javaMailSender.send(msg);
        } catch (Exception ex) {
            log.error("jupmoninfo: " + ex.getClass().getCanonicalName());
        }
    }

    void sendEmailOnDbDisconnection() {
        sendEmail(from, "Jupiter Monitor a fost deconenctat de la db" ,
                "Deconectare de la baza de date de mai mult de " + ms / 1000 +
                        " secunde la " + Utils.getFormattedCurrentTime()+ ". Acesta este un mesaj automat.", to);
    }
}
