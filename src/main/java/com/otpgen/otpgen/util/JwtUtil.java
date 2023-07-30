//package com.otpgen.otpgen.util;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//import java.util.Date;
//
//public class JwtUtil {
//
//    private static final String SECRET_KEY = "secret";
//
//    public static String generateToken(String email, String otp) {
//        JwtBuilder builder = Jwts.builder()
//                .setSubject(email)
//                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
//                .claim("otp", otp)
//                .signWith(SignatureAlgorithm.HS256, SECRET_KEY);
//
//        return builder.compact();
//    }
//
//    public static Claims parseToken(String token) {
//        return Jwts.parser()
//                .setSigningKey(SECRET_KEY)
//                .parseClaimsJws(token)
//                .getBody();
//    }
//
//
//}