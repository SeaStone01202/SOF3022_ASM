package com.springboot.asm.fpoly_asm_springboot.services;

import com.nimbusds.jose.JOSEException;
import com.springboot.asm.fpoly_asm_springboot.dto.request.AuthenticationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.IntrospectRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.AuthenticationResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    String generateToken(String username);

    IntrospectResponse introspect(IntrospectRequest token) throws JOSEException, ParseException;
}
