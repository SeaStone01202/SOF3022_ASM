package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.service.CookieService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

/**
 * Example use for Cookie service only, do not use in actual projects**/
@RestController
@RequestMapping("/cookie")
public class CookieController {
    private final CookieService cookieService;

    public CookieController(CookieService cookieService) {
        this.cookieService = cookieService;
    }

    // API để tạo cookie
    @PostMapping("/add")
    public String createCookie(HttpServletResponse response) {
        cookieService.createCookie(response, "myCookie", "cookieValue", 3600);
        return "Cookie has been set!";
    }

    // API để lấy giá trị cookie
    @GetMapping("/get")
    public String getCookie(HttpServletRequest request) {
        String value = cookieService.getValue(request, "myCookie");
        return value != null ? "Cookie value: " + value : "Cookie not found";
    }

    // API để xóa cookie
    @DeleteMapping("/delete")
    public String deleteCookie(HttpServletRequest request, HttpServletResponse response) {
        cookieService.removeCookie(request, response, "myCookie");
        return "Cookie deleted!";
    }
}
