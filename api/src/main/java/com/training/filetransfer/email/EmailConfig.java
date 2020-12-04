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

    public void sendEmail(){

        // Create a mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.host);
        mailSender.setPort(this.port);
        mailSender.setUsername(this.username);
        mailSender.setPassword(this.password);


        // Create an email instance

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("keltouma.tahi@gmail.com");
        mailMessage.setTo("keltouma.tahi@gmail.com");
        mailMessage.setSubject("test");
        mailMessage.setText("test test kdclcnaiv");

        // SEND MAIL

        mailSender.send(mailMessage);

    }

}
