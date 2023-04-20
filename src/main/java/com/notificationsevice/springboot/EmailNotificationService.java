package com.notificationsevice.springboot;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(String recipient, String subject, String message) throws MessagingException, jakarta.mail.MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
        mimeMessage.setContent(message, "text/html");
        helper.setTo(recipient);
        helper.setSubject(subject);
        mailSender.send(mimeMessage);
    }
}