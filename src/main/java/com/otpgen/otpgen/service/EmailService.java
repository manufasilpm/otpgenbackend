package com.otpgen.otpgen.service;

public interface EmailService {
    void sendOtp(String recipientEmail, String otp);
}