package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.springboot.asm.fpoly_asm_springboot.entity.ForgotPasswordToken;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.UserRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.redisrepo.ForgotPasswordTokenRepository;
import com.springboot.asm.fpoly_asm_springboot.service.ForgotPasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ForgotPasswordServiceImpl implements ForgotPasswordService {

    private final ForgotPasswordTokenRepository forgotPasswordTokenRepository;
    private final UserRepository userRepository;

    private static final long EXPIRATION_TIME = 10;

    @Override
    public Optional<ForgotPasswordToken> getForgotPasswordToken(String token) {

        return forgotPasswordTokenRepository.findById(token);

    }

    @Override
    public ForgotPasswordToken createForgotPasswordToken(String email) {

        User userExiting = userRepository.findByEmail(email)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        String token = UUID.randomUUID().toString();

        long expirationTime = Instant.now().plus(EXPIRATION_TIME, ChronoUnit.MINUTES).toEpochMilli();

        ForgotPasswordToken forgotPasswordToken = new ForgotPasswordToken(token, userExiting.getEmail(), expirationTime);

        return forgotPasswordTokenRepository.save(forgotPasswordToken);
    }

    @Override
    public boolean validateToken(String token) {

        Optional<ForgotPasswordToken> optionalToken = forgotPasswordTokenRepository.findById(token);

        if (optionalToken.isPresent()) {

            ForgotPasswordToken forgotToken = optionalToken.get();

            return forgotToken.getExpiresTime() > System.currentTimeMillis();

        }

        return false;
    }

    @Override
    public void deleteToken(String token) {

        forgotPasswordTokenRepository.deleteById(token);

    }
}
