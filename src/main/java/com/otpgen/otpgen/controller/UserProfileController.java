package com.otpgen.otpgen.controller;

import com.otpgen.otpgen.Dto.UserDetailsDto;
import com.otpgen.otpgen.model.User;
import com.otpgen.otpgen.repository.UserRepository;
import com.otpgen.otpgen.service.EmailService;
import com.otpgen.otpgen.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserProfileController {


    @Autowired
    UserProfileService userService;


    public UserProfileController(UserProfileService userService) {
        this.userService = userService;
    }


    @GetMapping("/{email}")
    public ResponseEntity<UserDetailsDto> getUserByEmail(@PathVariable String email) {


        UserDetailsDto user = userService.getUserByEmailId(email);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}