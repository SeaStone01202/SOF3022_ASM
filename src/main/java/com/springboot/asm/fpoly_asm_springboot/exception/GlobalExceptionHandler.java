package com.poly.exception;

import com.poly.dto.request.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    ResponseEntity<ApiResponse> handlingRuntimeException() {
        ApiResponse apiResponse = ApiResponse.builder().
                code(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode()).
                message(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage()).
                build();

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = IllegalArgumentException.class)
    ResponseEntity<ApiResponse> handlingIllegalArgumentException() {
        ApiResponse apiResponse = ApiResponse.builder().
                code(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode()).
                message(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage()).build();

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = AppException.class)
    ResponseEntity<ApiResponse> handlingAppException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();
        ApiResponse apiResponse = ApiResponse.builder().
                code(errorCode.getCode()).
                message(errorCode.getMessage()).build();

        return ResponseEntity.badRequest().body(apiResponse);
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ResponseEntity<ApiResponse> handlingMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        String enumKey = exception.getFieldError().getDefaultMessage();
        ErrorCode errorCode = ErrorCode.UNCATEGORIZED_EXCEPTION;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException e) {

        }
        ApiResponse apiResponse = ApiResponse.builder().
                code(errorCode.getCode()).
                message(errorCode.getMessage()).build();

        return ResponseEntity.badRequest().body(apiResponse);
    }

}
