package com.training.filetransfer.email;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Data
@Service
public class EmailConfig {

    @Value("${spring.mail.host}")
    private String host;

    @Value("${spring.mail.port}")
    private int port;

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    private String from;

    private String recipient;

    private String subject;

    private String text;

    public void sendEmail(String to, String senderEmail, boolean isSender){

        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.host);
        mailSender.setPort(this.port);
        mailSender.setUsername(this.username);
        mailSender.setPassword(this.password);


        // Create an email instance

        if(!isSender){
            subject = senderEmail + " sent you a file 🗂";
        }
        else{
            subject = to + " has downloaded your file 🗂";
            to = senderEmail;
        }

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("contact@filetransfer.io");
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(text = "Connect to filetransfer 🗃");

        // SEND MAIL

        mailSender.send(mailMessage);

    }

}
