package com.otpgen.otpgen.service;

public interface OtpService {

    boolean validateOtp(String email, String otp,String username,String password);
    String generateOtp(String email);
}