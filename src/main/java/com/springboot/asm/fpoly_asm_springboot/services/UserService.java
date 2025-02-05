package com.springboot.asm.fpoly_asm_springboot.services;

import com.springboot.asm.fpoly_asm_springboot.entities.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    void deleteUser(int id);

    User updateUser(User user);

    User findUserById(int id);

    List<User> findAllUsers();

    User findUserByEmail(String username);
}
