package com.neonatal.backend.services;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.neonatal.backend.entities.User;
import com.neonatal.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JwtUtils {

    // Secret key used to sign the JWT
    private static final String SECRET_KEY = "neonatal-outcomes";

    // JWT expiration time (10 minutes)
    private static final long JWT_EXPIRATION_TIME = 10 * 60 * 1000;

    // User Repository
    @Autowired
    private UserRepository userRepository;

    public JwtUtils() {}

    /**
     * Encode a JWT given the subject
     *
     * @param subject the subject of the JWT
     * @return the encoded JWT
     */
    public String encodeJwt(String subject) {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        Date now = new Date();
        Date expiration = new Date(now.getTime() + JWT_EXPIRATION_TIME);

        return JWT.create()
                .withSubject(subject)
                .withIssuedAt(now)
                .withExpiresAt(expiration)
                .sign(algorithm);
    }

    /**
     * Decode a JWT and return the subject
     *
     * @param jwt the encoded JWT
     * @return the subject of the JWT
     * @throws SignatureVerificationException if the JWT signature verification fails
     * @throws TokenExpiredException if the JWT has expired
     * @throws JWTDecodeException if the JWT is malformed
     */
    public String decodeJwt(String jwt) throws SignatureVerificationException, TokenExpiredException, JWTDecodeException {
        Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
        DecodedJWT decodedJWT = JWT.require(algorithm).build().verify(jwt);
        return decodedJWT.getSubject();
    }

    /**
     * Utility function to check the authorization for a endpoint request.
     *
     * @param authorization the authorization header from the endpoint request
     */
    public int checkAuthorization(String authorization){
        String jwt = authorization.substring(authorization.indexOf(" ") + 1);
        String user = decodeJwt(jwt);
        // List<User> userList = userRepository.getByUsername(user);
        int roleID = Integer.valueOf(userRepository.getRoleidByUsername(user));
        if (roleID == 1){
            // USER IS A NURSE
            return 1;
        } else if (roleID == 2) {
            // USER IS AN ADMIN
            return 2;
        } else {
            // USER DOES NOT EXIST
            return 0;
        }
    }
}


/*
    To encode a JWT, you can call the 'encodeJWT' method and pass the subject:

    String jwt = JwtUtils.encodeJwt("my-subject");
 */

/*
    To decode a JWT and get the subject, you can call the 'decodeJwt' method and pass in the encoded JWT:

    String subject = JwtUtils.decodeJwt(jwt);
 */