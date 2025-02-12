//package com.springboot.asm.fpoly_asm_springboot.service.impl;
//
//import com.springboot.asm.fpoly_asm_springboot.constant.Role;
//import com.springboot.asm.fpoly_asm_springboot.entity.User;
//import com.springboot.asm.fpoly_asm_springboot.service.AuthenticationService;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//
//@Component
//@RequiredArgsConstructor
//public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
//
//    private final AuthenticationService authenticationService;
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//                                        Authentication authentication) throws IOException {
//        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
//        String email = oAuth2User.getAttribute("email");
//
//        User user = authenticationService.getOrCreateUser(email);
//
//        String token = authenticationService.generateToken(user);
//
//        response.sendRedirect("http://localhost:8080/login/oauth?token=" + token);
//
//    }
//
//}
