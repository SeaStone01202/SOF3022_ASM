package com.springboot.asm.fpoly_asm_springboot.services;

import com.springboot.asm.fpoly_asm_springboot.dto.request.UserRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.UserResponse;

import java.util.List;

public interface UserService {
    UserResponse create(UserRequest userRequest);
    UserResponse update(UserRequest userRequest);
    Boolean delete(UserRequest userRequest);
    List<UserResponse> findAll();
}
