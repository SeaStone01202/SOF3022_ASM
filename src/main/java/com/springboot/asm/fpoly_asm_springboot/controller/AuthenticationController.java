package com.springboot.asm.fpoly_asm_springboot.controller;

import com.nimbusds.jose.JOSEException;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.AuthenticationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.IntrospectRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.AuthenticationResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.IntrospectResponse;
import com.springboot.asm.fpoly_asm_springboot.services.AuthenticationService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationController {

    final AuthenticationService authenticationService;

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> authentica(@RequestBody AuthenticationRequest request) {

        var result = authenticationService.authenticate(request);
        return ApiResponse.<AuthenticationResponse>builder().
                result(result).
                build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {
        var result = authenticationService.introspect(request);
        return ApiResponse.<IntrospectResponse>builder().result(result).build();
    }

}
