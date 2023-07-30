package com.otpgen.otpgen.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;

    public EmailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendOtp(String recipientEmail, String otp) {
        // Create a simple email message
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(recipientEmail);
        mailMessage.setSubject("Your OTP for verification");
        mailMessage.setText("Your OTP is: " + otp);

        // Send the email
        javaMailSender.send(mailMessage);
    }
}