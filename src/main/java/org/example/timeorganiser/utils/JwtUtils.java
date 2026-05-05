package org.example.timeorganiser.utils;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtils {
    @Value("${timeorganiser.app.jwtSecret}")
    private String jwtSecret;

    @Value("${timeorganiser.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
    public String generateToken(String username){
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key())
                .compact();
    }

    public String getUsernameFromToken(String token){
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build()
                .parseUnsecuredClaims(token)
                .getPayload()
                .getSubject();
    }

    public boolean validateToken(String authToken){
        try{
            Jwts.parser().verifyWith((SecretKey) key()).build().parse(authToken);
            return true;
        }catch (Exception e){
            throw new JwtException("Invalid token");
        }
    }
}
