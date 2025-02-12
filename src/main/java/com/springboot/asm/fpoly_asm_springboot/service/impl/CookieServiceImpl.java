package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.springboot.asm.fpoly_asm_springboot.service.CookieService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Arrays;
import java.util.Optional;

public class CookieServiceImpl implements CookieService {

    HttpSession session;
    HttpServletRequest request;
    @Override
    public Optional<Cookie> getCookie(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            return Arrays.stream(request.getCookies())
                    .filter(cookie -> name.equals(cookie.getName()))
                    .findFirst();
        }
        return Optional.empty();
    }

    @Override
    public void createCookie(HttpServletResponse response, String name, String value, int maxAge) {
        Cookie cookie = new Cookie(name, value);
        cookie.setPath("/");  // Cookie áp dụng cho toàn bộ domain
        cookie.setHttpOnly(true); // Giúp ngăn chặn JavaScript truy cập (bảo mật)
        cookie.setMaxAge(maxAge); // Thời gian sống của cookie (giây)
        response.addCookie(cookie);
    }

    @Override
    public void removeCookie(HttpServletRequest request, HttpServletResponse response, String name) {
        getCookie(request, name).ifPresent(cookie -> {
            cookie.setValue("");
            cookie.setPath("/");
            cookie.setMaxAge(0);  // Đặt thời gian sống về 0 để xóa
            response.addCookie(cookie);
        });
    }

    @Override
    public String getValue(HttpServletRequest request, String name) {
        return getCookie(request, name).map(Cookie::getValue).orElse(null);
    }
}
