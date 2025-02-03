package com.springboot.asm.fpoly_asm_springboot.exception;

import lombok.Getter;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001,"User already existed"),
    UNCATEGORIZED_EXCEPTION(9999,"Uncategorized error"),
    USERNAME_INVALID(1003,"Username is invalid, please input at least 3 characters"),
    PASSWORD_INVALID(1004,"Password is invalid, please input at least 8 characters"),
    USER_NOT_EXISTED(1005,"User not existed"),
    UNAUTHENTICATED_EXCEPTION(1006,"Unauthenticated error"),
    PRODUCT_NOT_EXISTED(1007,"Product not existed"),
    PRODUCT_ALREADY_EXISTED(1008,"Product already existed"),
    ;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
