package com.cotsoft.apicontactos.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class TokenUtils {

    private final static String ACCES_TOKEN_SECRET = "p7NZZBrp20fhPXnNjyG9Wp7NZZBrp20fhPXnNjyG9Wp7NZZBrp20fhPXnNjyG9W";
    private final static Long ACCES_TOKEN_VALIDITY_SECONDS = 2592000L;

    public static String createToken(String name, String email){
        long expirationTime = ACCES_TOKEN_VALIDITY_SECONDS * 1000;
        Date expirationDate = new Date(System.currentTimeMillis() * expirationTime);
        Map<String, Object> extra = new HashMap<>();
        extra.put("nombre", name);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){
      try{
          Claims claims = Jwts.parserBuilder()
                  .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                  .build()
                  .parseClaimsJws(token)
                  .getBody();

          String email = claims.getSubject();

          return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
      }
      catch (JwtException e){
          return null;
      }
    }

}
