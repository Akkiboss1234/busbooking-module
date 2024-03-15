package com.busbookingreservation.util;


// EmailService.java
import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


    @Service
    public class EmailService {

        private final JavaMailSender javaMailSender;

        public EmailService(JavaMailSender javaMailSender) {
            this.javaMailSender = javaMailSender;
        }

        public void sendEmailWithAttachment(String to, String subject, String text, byte[] attachment, String attachmentName) throws MessagingException, MessagingException {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text);

            DataSource dataSource= new ByteArrayDataSource(attachment,"application/pdf");
            helper.addAttachment(attachmentName,dataSource );

            javaMailSender.send(message);
        }
    }


