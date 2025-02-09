package com.springboot.asm.fpoly_asm_springboot.controller;

import com.nimbusds.jose.JOSEException;
import com.springboot.asm.fpoly_asm_springboot.dto.request.*;
import com.springboot.asm.fpoly_asm_springboot.dto.response.AuthenticationResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.IntrospectResponse;
import com.springboot.asm.fpoly_asm_springboot.service.AuthenticationService;
import com.springboot.asm.fpoly_asm_springboot.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final CartService cartService;

    @PostMapping("/token")
    public ApiResponse<AuthenticationResponse> authenticationResponseApiResponse(@RequestBody AuthenticationRequest request) {

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

    @PostMapping("/logout")
    ApiResponse<?> logout(@RequestBody LogoutRequest request) throws ParseException, JOSEException {

        var email = authenticationService.getCurrentUserEmail(request);

        cartService.saveCartOnLogout(email);

        authenticationService.logout(request);

        return ApiResponse.<String>builder().
                result("Account is logged out successfully ").
                build();
    }
//
//    @PostMapping("/refresh")
//    ApiResponse<AuthenticationResponse> refresh(@RequestBody RefreshRequest request) throws ParseException, JOSEException {
//        return ApiResponse.<AuthenticationResponse>builder().
//                result(authenticationService.refreshToken(request)).
//                build();
//    }
}
