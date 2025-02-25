package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import com.springboot.asm.fpoly_asm_springboot.constant.Role;
import com.springboot.asm.fpoly_asm_springboot.dto.request.AuthenticationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.IntrospectRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.LogoutRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.RefreshRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.AuthenticationResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.IntrospectResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.UserGGResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.InvalidatedToken;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.mapper.UserMapper;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.InvalidateTokenRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.UserRepository;
import com.springboot.asm.fpoly_asm_springboot.service.AuthenticationService;
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
import java.util.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final InvalidateTokenRepository invalidatedTokenRepository;

    private final UserMapper userMapper;

    @NonFinal
    @Value("${jwt.signerKey}")
    protected String secretKey;

    @NonFinal
    @Value("${jwt.valid-duration}")
    protected long VALID_DURATION;

    @NonFinal
    @Value("${jwt.refreshable-duration}")
    protected long REFRESHABLE_DURATION;

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

        var user = userRepository.findByEmail(
                        authenticationRequest
                                .getEmail())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));


        boolean authenticated = passwordEncoder.matches(authenticationRequest.getPassword(), user.getPassword());

        if (!authenticated) {

            throw new AppException(ErrorCode.UNCATEGORIZED_EXCEPTION);
        }

        var token = generateToken(user);

        return AuthenticationResponse.builder().
                token(token).
                authenticated(true).
                build();
    }

    @Override
    public String generateToken(User user) {
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);

        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder().
                subject(user.getEmail()).
                issuer("poly.com").
                issueTime(new Date()).
                expirationTime(new Date(
                        Instant.now()
                                .plus(VALID_DURATION, ChronoUnit.HOURS)
                                .toEpochMilli())).
                claim("scope", buildScope(user)).
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

        boolean isValid = true;

        try {
            verifyToken(token, false);
        } catch (AppException e) {

            isValid = false;

        }

        return IntrospectResponse.builder().valid(isValid).build();

    }

    @Override
    public void logout(LogoutRequest request) throws ParseException, JOSEException {
        try {
            var signToken = verifyToken(request.getToken(), true);

            Date expiryTime = signToken.getJWTClaimsSet().getExpirationTime();

            InvalidatedToken invalidatedToken =
                    InvalidatedToken.builder()
                            .id(request.getToken())
                            .expiryTime(expiryTime)
                            .build();

            invalidatedTokenRepository.save(invalidatedToken);

        } catch (AppException exception) {

            log.info("Token already expired");

        }
    }

    private SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException {

        JWSVerifier verifier = new MACVerifier(secretKey.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiryTime = (isRefresh)
                ? new Date(signedJWT
                .getJWTClaimsSet()
                .getIssueTime()
                .toInstant()
                .plus(REFRESHABLE_DURATION, ChronoUnit.SECONDS)
                .toEpochMilli())
                : signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier);

        if (!(verified && expiryTime.after(new Date()))) throw new AppException(ErrorCode.UNAUTHENTICATED_EXCEPTION);


        return signedJWT;
    }

    @Override
    public AuthenticationResponse refreshToken(RefreshRequest request) throws ParseException, JOSEException {
        var signedJWT = verifyToken(request.getToken(), true);

        var expiryTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        InvalidatedToken invalidatedToken = InvalidatedToken.builder().
                expiryTime(expiryTime).
                build();

        invalidatedTokenRepository.save(invalidatedToken);

        var email = signedJWT.getJWTClaimsSet().getSubject();

        var user = userRepository.findByEmail(email).orElseThrow(() -> new AppException(ErrorCode.UNAUTHENTICATED_EXCEPTION));

        var token = generateToken(user);

        return AuthenticationResponse.builder().
                token(token).
                authenticated(true).
                build();
    }


    private String buildScope(User user) {
        StringJoiner scope = new StringJoiner(" ");

        if (user.getRole().describeConstable().isPresent()) {

            scope.add(user.getRole() ? "ADMIN" : "USER");

        }

        return scope.toString();
    }


    @Override
    public User getOrCreateUser(User user) {

        User userOauth2 = userRepository.findByEmail(user.getEmail())
                .orElseGet(() -> {

                    User newUser = new User();

                    newUser.setEmail(user.getEmail());

                    newUser.setPassword("");

                    newUser.setRole(Role.USER);

                    newUser.setAvatar(user.getAvatar());

                    return userRepository.save(newUser);
                });

        UserGGResponse userResponse = UserGGResponse.builder()
                .email(userOauth2.getEmail())
                .avatar(userOauth2.getAvatar())
                .role(userOauth2.getRole())
                .fullName(userOauth2.getFullName())
                .id(userOauth2.getId())
                .build();

        userResponse.setToken(generateToken(userOauth2));

        return userOauth2;
    }

    @Override
    public User getOrCreateUser(String email) {
        return userRepository.findByEmail(email)
                .orElseGet(() -> {

                    User newUser = new User();

                    newUser.setEmail(email);

                    newUser.setPassword("");

                    newUser.setRole(Role.USER);

                    return userRepository.save(newUser);
                });
    }
}
