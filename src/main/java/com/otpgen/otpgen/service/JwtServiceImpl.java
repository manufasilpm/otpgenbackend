//package com.otpgen.otpgen.service;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import io.jsonwebtoken.io.Decoder;
//import io.jsonwebtoken.io.Decoders;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.security.Key;
//import java.util.*;
//
//public class JwtServiceImpl implements JwtService {
//    @Override
//    public String extractUserName(String token) {
//        return null;
//    }
//
//    @Override
//    public String generateToken(String email) {
//        Map<String, Object> claims = new HashMap<>();
//        return createToken(claims, email);
//    }
//    private String SECRET_KEY = "secret";
//    private String createToken(Map<String, Object> claims, String email) {
//        return Jwts.builder()
//                .setSubject(email)
//                .setIssuedAt(new Date())
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                .compact();
//
//    }
//    public boolean validateToken(String token) {
//        try {
//            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//
//
//    @Override
//    public boolean isTokenValid(String token, UserDetails userDetails) {
//        return false;
//    }
//}
