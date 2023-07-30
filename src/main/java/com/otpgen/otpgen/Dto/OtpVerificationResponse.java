package com.otpgen.otpgen.Dto;



import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class OtpVerificationResponse {
    private boolean isOtpValid;

    public OtpVerificationResponse(boolean isOtpValid) {
        this.isOtpValid = isOtpValid;
    }

    // Getter...
}