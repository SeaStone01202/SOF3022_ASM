package com.springboot.asm.fpoly_asm_springboot.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    USER_EXISTED(1001, "User already existed", HttpStatus.CONFLICT),
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error", HttpStatus.INTERNAL_SERVER_ERROR),
    USERNAME_INVALID(1003, "Username is invalid, please input at least 3 characters", HttpStatus.BAD_REQUEST),
    PASSWORD_INVALID(1004, "Password is invalid, please input at least 8 characters", HttpStatus.BAD_REQUEST),
    USER_NOT_EXISTED(1005, "User not existed", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED_EXCEPTION(1006, "Unauthenticated error", HttpStatus.UNAUTHORIZED),
    PRODUCT_NOT_EXISTED(2001, "Product not existed", HttpStatus.NOT_FOUND),
    PRODUCT_ALREADY_EXISTED(2005, "Product already existed", HttpStatus.CONFLICT),
    UNAUTHORIZED(1009, "You don't have permission", HttpStatus.FORBIDDEN),
    INVALID_KEY(9991, "Invalid key", HttpStatus.BAD_REQUEST),
    FIELD_BLANK(1011, "Field first name is blank", HttpStatus.BAD_REQUEST),
    CATEGORY_EXISTED(3001, "Category already existed", HttpStatus.CONFLICT),
    CATEGORY_NOT_EXISTED(3005, "Category not existed", HttpStatus.CONFLICT),

    ;

    private int code;
    private String message;
    private HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

}
