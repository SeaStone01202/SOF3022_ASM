package com.springboot.asm.fpoly_asm_springboot.service;

import com.nimbusds.jose.JOSEException;
import com.springboot.asm.fpoly_asm_springboot.dto.request.AuthenticationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.IntrospectRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.LogoutRequest;

import com.springboot.asm.fpoly_asm_springboot.dto.request.RefreshRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.AuthenticationResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.IntrospectResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.User;

import java.text.ParseException;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    String generateToken(User user);

    IntrospectResponse introspect(IntrospectRequest token) throws JOSEException, ParseException;

    User getOrCreateUser(User user);

    User getOrCreateUser(String email);

    void logout(LogoutRequest token) throws ParseException, JOSEException;

    AuthenticationResponse refreshToken(RefreshRequest request) throws ParseException, JOSEException;
}
