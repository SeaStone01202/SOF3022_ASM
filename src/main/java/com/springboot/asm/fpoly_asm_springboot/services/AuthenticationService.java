package com.poly.service;

import com.nimbusds.jose.JOSEException;
import com.poly.dto.request.AuthenticationRequest;
import com.poly.dto.request.IntrospectRequest;
import com.poly.dto.response.AuthenticationResponse;
import com.poly.dto.response.IntrospectResponse;

import java.text.ParseException;

public interface AuthenticationService {

    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    String generateToken(String username);

    IntrospectResponse introspect(IntrospectRequest token) throws JOSEException, ParseException;
}
