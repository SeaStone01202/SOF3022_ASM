package com.springboot.asm.fpoly_asm_springboot.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ErrorDetails {

    private LocalDateTime timestamp;

    private String message;

    private String details;

}
