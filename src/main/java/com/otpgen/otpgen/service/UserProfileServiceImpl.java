package com.otpgen.otpgen.service;

import com.otpgen.otpgen.Dto.UserDetailsDto;
import com.otpgen.otpgen.model.User;
import com.otpgen.otpgen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserProfileServiceImpl implements UserProfileService {


    private final UserRepository userRepository;
    @Autowired
    public UserProfileServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }




    @Override
    public UserDetailsDto getUserByEmailId(String email) {
        System.out.println("service");
        
        User user=userRepository.findByEmail(email);
        if (user != null) {
            return mapUserToDto(user);
        }
        return null;
    }

    private UserDetailsDto mapUserToDto(User user) {
        UserDetailsDto userDTO = new UserDetailsDto();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }


}