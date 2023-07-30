package com.otpgen.otpgen.service;

import com.otpgen.otpgen.Dto.UserDetailsDto;
import com.otpgen.otpgen.model.User;

public interface UserProfileService {

    UserDetailsDto getUserByEmailId(String email);

}