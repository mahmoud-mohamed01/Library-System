package com.maidsTask.LibrarySystem.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.maidsTask.LibrarySystem.model.Patron;
import com.maidsTask.LibrarySystem.service.JwtService;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImp  implements JwtService {



    @Value("${jwt.alogorithm.key}")
    private String algorithmKey;
    @Value("${jwt.issuer}")
    private String issuer;
    @Value("${jwt.expiryInSeconds}")
    private int expiryInSeconds;
    private Algorithm algorithm;

    @PostConstruct
    public void postConstuct(){
        algorithm=Algorithm.HMAC256(algorithmKey);
    }

    @Override
    public String generateJwt(Patron patron) {
        return JWT.create().
                withClaim("patron_email",patron.getEmail()).
                withIssuer(issuer).
                withExpiresAt(new Date(System.currentTimeMillis()+(1000*expiryInSeconds))).
                sign(algorithm);
    }

    @Override
    public String getEmail(String token) {
        return JWT.decode(token).getClaim("patron_email").asString();

    }
}
