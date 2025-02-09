package com.springboot.asm.fpoly_asm_springboot.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UserAuthenticationException extends UserException {
    public UserAuthenticationException(String message) {
        super(message);
    }
}