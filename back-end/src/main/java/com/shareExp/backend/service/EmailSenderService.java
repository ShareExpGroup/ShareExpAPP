package com.shareExp.backend.service;


import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {

    private JavaMailSender mailSender;


    public void sendSimpleEmail(
            String toEmail,
            String body,
            String subject
    ) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("hajar.dami.14@gmail.com");
        msg.setTo(toEmail);
        msg.setSubject(subject);
        msg.setText(body);

        mailSender.send(msg);
    }
}
