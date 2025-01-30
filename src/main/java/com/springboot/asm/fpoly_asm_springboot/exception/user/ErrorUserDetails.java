package com.springboot.asm.fpoly_asm_springboot.exception.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorUserDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;
    private Integer userId;
}
