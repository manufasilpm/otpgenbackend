package com.otpgen.otpgen.repository;

import com.otpgen.otpgen.model.Otp;
import com.otpgen.otpgen.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OtpRepository extends JpaRepository<Otp,Long> {
    Otp findByEmail(String email);
}
