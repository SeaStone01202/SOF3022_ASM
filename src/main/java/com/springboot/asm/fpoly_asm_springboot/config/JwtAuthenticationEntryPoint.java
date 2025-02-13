package com.springboot.asm.fpoly_asm_springboot.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ErrorCode errorCode = ErrorCode.UNAUTHORIZED;

        response.setStatus(errorCode.getHttpStatus().value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        ObjectMapper mapper = new ObjectMapper();

        ApiResponse<?> apiResponse = ApiResponse.builder().
                code(errorCode.getCode()).
                message(errorCode.getMessage()).
                build();

        response.getWriter().write(mapper.writeValueAsString(apiResponse));
        response.flushBuffer();
    }
}
