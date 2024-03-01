package com.techlearners.blogapp.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    // TODO: Move the key to a separate .properties file (not in git)
    private static final String JWT_KEY = "lsdknfsdnsdngkin3243onisdfkn3e3";
    private Algorithm algorithm = Algorithm.HMAC256(JWT_KEY);

    public String createJwt(Long userId){
        return JWT.create()
                .withSubject(userId.toString())
                .withIssuedAt(new Date())
                // .withExpiresAt()
                .sign(algorithm);
    }


    public Long retrieveUserId(String jwtString){
        var decodedJWT =  JWT.decode(jwtString);
        var userId = Long.valueOf((decodedJWT.getSubject()));
        return userId;
    }

}
