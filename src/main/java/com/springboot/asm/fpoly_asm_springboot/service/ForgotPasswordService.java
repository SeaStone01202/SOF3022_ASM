package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.entity.ForgotPasswordToken;

import java.util.Optional;

public interface ForgotPasswordService {

    Optional<ForgotPasswordToken> getForgotPasswordToken(String token);

    ForgotPasswordToken createForgotPasswordToken(String email);

    boolean validateToken(String token);

    void deleteToken(String token);
}
