package com.br.b2b.service.auth;

import com.br.b2b.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.security.SecureRandom;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class JwtService {

    private final Key SECRET_KEY;

    public JwtService() {
        // Gera uma chave aleatória com 256 bits de tamanho
        this.SECRET_KEY = generateSecretKey();
    }

    private Key generateSecretKey() {
        // Define o tamanho da chave em bytes (256 bits = 32 bytes)
        int keySizeBytes = 32;

        // Cria um array de bytes para armazenar a chave
        byte[] keyBytes = new byte[keySizeBytes];

        // Gera a chave aleatória
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(keyBytes);

        // Retorna a chave gerada, representada em Base64
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public Object generateTokenUser(Optional<User> user) {
        return null;
    }

    public String extractUserEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        String token = "";
        try {
            token = generateToken(new HashMap<>(), userDetails);
        } catch (Exception e) {
            System.out.println(e);
        }
        return token;
    }

    public String generateToken(Map<String, Object> s, UserDetails userDetails) {
        return Jwts.builder().claims(s).subject(userDetails.getUsername()).issuedAt(new Date(System.currentTimeMillis())).expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)).signWith(getSignInKeys(), SignatureAlgorithm.HS256).compact();
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUserEmail(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));

    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(getSignInKeys()).build().parseSignedClaims(token).getPayload();
    }

    private Key getSignInKeys() {
        return SECRET_KEY;
    }
}

