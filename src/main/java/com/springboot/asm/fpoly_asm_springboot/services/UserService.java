package com.poly.service;

import com.poly.dto.request.UserCreationRequest;
import com.poly.dto.request.UserUpdatedRequest;
import com.poly.dto.response.UserResponse;
import com.poly.enity.User;

import java.util.List;


public interface UserService {

    UserResponse createUser(UserCreationRequest request);

    List<User> getUsers();

    UserResponse getUserById(String id);

    UserResponse updateUser(String userId, UserUpdatedRequest request);

    void deleteUser(String userId);


}

