package com.springboot.asm.fpoly_asm_springboot.service;

import jakarta.servlet.http.HttpServletRequest;

public interface MailService {

    void sendForgotPasswordMail(HttpServletRequest request,String token);
}
