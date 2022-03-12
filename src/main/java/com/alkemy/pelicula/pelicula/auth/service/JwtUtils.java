package com.alkemy.pelicula.pelicula.auth.service;

import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.security.Signature;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    public String SECRET_KEY = "Secret";
    public  String extractUsername(String token){ return extractClaim(token, Claims::getSubject);}
    public Date extractExpiration(String token){ return  extractClaim(token, claims::getExpiration);}
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver){
        final Claims claims = extractAllClaims(token);

    }
    private Claims extractAllClaims(String token){
        return Jwts.parser().setSigningkey(SECRET_KEY).parseClaimsJws(token).getBody();

    }
    private Boolean isTokenExpired(String token){ return extractExpiration(token).before(new Date())
    public String generateToken(UserDetails userDetails){
            Map<String, Object> claims = new HashMap<>();
            return createToken(claims, userDetails.getUsername());
        }
        private String createToken(Map<String, Object> claims, String subject )
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60* 10))
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
    }
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUsername(token);
        return(username.equals(userDetails.getUsername()) && !isTokenExpired(token));

}
}
