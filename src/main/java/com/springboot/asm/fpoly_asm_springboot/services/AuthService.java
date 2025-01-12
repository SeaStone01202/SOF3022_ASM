package com.springboot.asm.fpoly_asm_springboot.services;


import com.springboot.asm.fpoly_asm_springboot.dto.request.LoginRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.LoggedUser;

public interface AuthService {

    LoggedUser login(LoginRequest loginRequest);

}
