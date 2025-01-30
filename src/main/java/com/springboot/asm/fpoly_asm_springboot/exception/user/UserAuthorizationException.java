package com.springboot.asm.fpoly_asm_springboot.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class UserAuthorizationException extends UserException {
    public UserAuthorizationException(String message) {
        super(message);
    }
}
