package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.ForgotPasswordToken;
import com.springboot.asm.fpoly_asm_springboot.service.ForgotPasswordService;
import com.springboot.asm.fpoly_asm_springboot.service.MailService;
import com.springboot.asm.fpoly_asm_springboot.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reset-password")
@RequiredArgsConstructor
public class ForgotPasswordController {

    private final MailService mailService;
    private final ForgotPasswordService forgotPasswordService;
    private final UserService userService;

    @GetMapping("/request")
    public ApiResponse<?> doResetPassword(HttpServletRequest request) {

        ForgotPasswordToken forgotPasswordToken = forgotPasswordService
                .createForgotPasswordToken(
                        request.getParameter("email"));

        mailService.sendForgotPasswordMail(request, forgotPasswordToken.getToken());

        return ApiResponse.<ForgotPasswordToken>builder()
                .result(forgotPasswordToken)
                .build();
    }

    @GetMapping
    public ApiResponse<?> resetPasswordValidation(@RequestParam String token) {
        boolean valid = forgotPasswordService.validateToken(token);
        if (valid) {
            return ApiResponse.builder()
                    .result("valid")
                    .build();
        } else {
            return ApiResponse.builder()
                    .code(9999)
                    .result("invalid")
                    .build();
        }

    }

    @PostMapping("/reset")
    public ApiResponse<?> resetPassword(@RequestParam String token, @RequestParam String newPassword) {

        if (!forgotPasswordService.validateToken(token)) {

            return ApiResponse.builder()
                    .code(9999)
                    .result("invalid token or expired")
                    .build();

        }

        String email = forgotPasswordService.getForgotPasswordToken(token).orElseThrow().getEmail();

        userService.updatePassword(email, newPassword);

        forgotPasswordService.deleteToken(token);

        return ApiResponse.builder()
                .result("Password reset successfully")
                .build();
    }
}
