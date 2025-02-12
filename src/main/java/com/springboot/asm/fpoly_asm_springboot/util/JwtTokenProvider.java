package com.springboot.asm.fpoly_asm_springboot.util;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.text.ParseException;
import java.util.Date;

@Component
public class JwtTokenProvider {

    public boolean validateToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();

            if (claims.getExpirationTime().before(new Date())) {
                return false;
            }
            return true;
        } catch (ParseException e) {
            throw new RuntimeException("Error parsing JWT token", e);
        }
    }

    public String getEmailFromToken(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();
            return claims.getSubject();
        } catch (ParseException e) {
            throw new RuntimeException("Error extracting username from JWT", e);
        }
    }

    public boolean isAdmin(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            JWTClaimsSet claims = signedJWT.getJWTClaimsSet();

            return claims.getBooleanClaim("isAdmin");
        } catch (ParseException e) {
            throw new RuntimeException("Invalid JWT token", e);
        }
    }

}