package com.springboot.asm.fpoly_asm_springboot.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CookieService {
    Optional<Cookie> getCookie(HttpServletRequest request, String name);
    void createCookie(HttpServletResponse response, String name, String value, int maxAge);
    void removeCookie(HttpServletRequest request, HttpServletResponse response, String name);
    String getValue(HttpServletRequest request, String name);
}
