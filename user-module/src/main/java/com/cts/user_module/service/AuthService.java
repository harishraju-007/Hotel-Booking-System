//package com.cts.user_module.service;
//
//import com.cts.user_module.enums.Role;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//import javax.crypto.SecretKey;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.UUID;
//import java.util.function.Function;
//
//@Service
//public class AuthService {
//
//    private final String key = "asdfghjklqwertyuiopzxcvbnm1234567890987654321asdfghjklmoijnbjuygvcftredxzsewa";
//
//    private final SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode(key));
//
//    public String getToken(String email, UUID userId, Role role){
//        Map<String, String> claims = new HashMap<>();
//        claims.put("userId", userId.toString());
//        claims.put("role", role.toString());
//        return Jwts.builder().claims(claims).subject(email).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis()+60*60*1000)).signWith(secretKey).compact();
//    }
//
//    public String extractEmail(String token) {
//        return extractClaim(token, Claims::getSubject);
//    }
//    public String extractUserId(String token) {
//        return extractClaim(token, claims -> claims.get("userId", String.class));
//    }
//    public String extractRole(String token) {
//        return extractClaim(token, claims -> claims.get("role", String.class));
//    }
//    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
//        final Claims claims = extractAllClaims(token);
//        return claimResolver.apply(claims);
//    }
//    private Claims extractAllClaims(String token) {
//        return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload();
//    }
//
//    public boolean validateToken(String token, UserDetails userDetails) {
//        final String userName = extractEmail(token);
//        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
//    }
//
//    private boolean isTokenExpired(String token) {
//        return extractExpiration(token).before(new Date());
//    }
//
//    private Date extractExpiration(String token) {
//        return extractClaim(token, Claims::getExpiration);
//    }
//}
