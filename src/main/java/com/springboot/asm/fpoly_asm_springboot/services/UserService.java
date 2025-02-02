package com.springboot.asm.fpoly_asm_springboot.services;


import com.springboot.asm.fpoly_asm_springboot.dto.request.UserCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.UserResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.User;

import java.util.List;


public interface UserService {

    UserResponse createUser(UserCreationRequest request);

    List<User> getUsers();

    UserResponse getUserById(Integer id);

    UserResponse updateUser(Integer userId, UserUpdatedRequest request);

    void deleteUser(Integer userId);


}

