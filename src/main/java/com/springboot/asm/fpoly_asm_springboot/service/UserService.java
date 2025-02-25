package com.springboot.asm.fpoly_asm_springboot.service;


import com.springboot.asm.fpoly_asm_springboot.dto.request.UserCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.UserResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;


public interface UserService {

    UserResponse createUser(UserCreationRequest request);

    Page<UserResponse> getUsers(int page);

    UserResponse getUserById(Integer id);

    UserResponse updateUser(Integer userId, UserUpdatedRequest request);

    UserResponse getMyInfo();

    User findByEmail(String email);

    void deleteUser(Integer userId);

    void uploadAvatar(Integer userId,MultipartFile file);

    void updatePassword(String email, String newPassword);
}

