package com.springboot.asm.fpoly_asm_springboot.service;


import com.springboot.asm.fpoly_asm_springboot.dto.request.UserCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


public interface UserService {

    UserResponse createUser(UserCreationRequest request);

    List<UserResponse> getUsers();

    UserResponse getUserById(Integer id);

    UserResponse updateUser(Integer userId, UserUpdatedRequest request);

    UserResponse getMyInfo();

    void deleteUser(Integer userId);

    void uploadAvatar(Integer userId,MultipartFile file);
}

