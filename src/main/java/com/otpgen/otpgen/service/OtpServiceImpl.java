package com.otpgen.otpgen.service;

import com.otpgen.otpgen.model.Otp;
import com.otpgen.otpgen.model.User;
import com.otpgen.otpgen.repository.OtpRepository;
import com.otpgen.otpgen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OtpServiceImpl implements OtpService {

    @Autowired
    private final OtpRepository otpRepo;

    @Autowired
    private UserRepository userrepo;


    private static final int OTP_LENGTH = 6;

    public OtpServiceImpl(OtpRepository otpRepo, EmailService emailService) {
        this.otpRepo = otpRepo;

    }


    @Override
    public boolean validateOtp(String email, String otp,String username,String password) {
        Otp userOtp = otpRepo.findByEmail(email);
            if (userOtp != null && otp.equals(userOtp.getOtp())){
                User userEntity = new User();
                userEntity.setEmail(email);
                userEntity.setUsername(username);
                userEntity.setPassword(password);
                userEntity.setOtp(otp);
                userrepo.save(userEntity);
                otpRepo.delete(userOtp);
                return true;
            }
            else return false;


    }

    @Override
    public String generateOtp(String email) {
        int otpValue = (int) (Math.random() * Math.pow(10, OTP_LENGTH));
        String otp = String.format("%0" + OTP_LENGTH + "d", otpValue);
        Otp otpEntity = new Otp();
        otpEntity.setEmail(email);
        otpEntity.setOtp(otp);
        otpRepo.save(otpEntity);
        return "otp Generated";
    }
}