package com.otpgen.otpgen.controller;


import com.otpgen.otpgen.Dto.OtpGenerationRequest;
import com.otpgen.otpgen.Dto.OtpGenerationResponse;
import com.otpgen.otpgen.Dto.OtpVerificationRequest;
import com.otpgen.otpgen.Dto.OtpVerificationResponse;
import com.otpgen.otpgen.model.User;
import com.otpgen.otpgen.service.EmailService;
import com.otpgen.otpgen.service.OtpService;
//import com.otpgen.otpgen.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")
public class OtpController {
    @Autowired
    EmailService emailService;

    @Autowired
    private OtpService otpService;



    @GetMapping("/")
    public String showOtpPage() {
        return "otp";
    }

    @PostMapping("/generateOtp")
    public ResponseEntity<OtpGenerationResponse> generateOtp(@RequestBody OtpGenerationRequest request) {
        String email = request.getEmail();
        String generatedOtp = otpService.generateOtp(email);
        OtpGenerationResponse response = new OtpGenerationResponse(generatedOtp);
        return ResponseEntity.ok(response);
    }



    @PostMapping("/verifyOtp")
    public ResponseEntity<OtpVerificationResponse> verifyOtp(@RequestBody User request) {
        String email = request.getEmail();
        String otp = request.getOtp();
        String username = request.getUsername();
        String password = request.getPassword();

        boolean isOtpValid = otpService.validateOtp(email, otp,username,password);
        OtpVerificationResponse response = new OtpVerificationResponse(isOtpValid);
//        JwtUtil jwt=new JwtUtil();
//        if (isOtpValid){
//
//            String token=jwt.generateToken(email,otp);
//
//            System.out.println(token);
//        }
        return ResponseEntity.ok(response);
    }


}