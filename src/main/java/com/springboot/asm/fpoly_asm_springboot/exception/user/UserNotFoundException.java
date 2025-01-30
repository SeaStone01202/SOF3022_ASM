package com.springboot.asm.fpoly_asm_springboot.exception.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND )
public class UserNotFoundException extends UserException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
