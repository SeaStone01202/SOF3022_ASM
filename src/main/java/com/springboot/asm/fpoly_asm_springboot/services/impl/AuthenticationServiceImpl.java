package com.springboot.asm.fpoly_asm_springboot.services.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.springboot.asm.fpoly_asm_springboot.dto.request.AuthenticationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.IntrospectRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.AuthenticationResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.IntrospectResponse;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.repositories.UserRepository;
import com.springboot.asm.fpoly_asm_springboot.services.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String secretKey;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        var user = userRepository.findByEmail(authenticationRequest.getEmail()).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());
        if (!authenticated) {
            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }
        var token = generateToken(user.getEmail());
        return AuthenticationResponse.builder().
                token(token).
                authenticated(true).
                build();
    }

    @Override
    public String generateToken(String username) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder().subject(username).
                issuer("poly.com").
                issueTime(new Date()).
                expirationTime(new Date(Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli())).
                build();

        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(secretKey.getBytes()));
            return jwsObject.serialize();
        } catch (JOSEException e) {
            log.error("Can't generate token", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {

        var token = request.getToken();

        JWSVerifier verifier = new MACVerifier(secretKey.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expirationTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        return IntrospectResponse.builder().
                valid(verified && expirationTime.after(new Date())).
                build();

    }
}
