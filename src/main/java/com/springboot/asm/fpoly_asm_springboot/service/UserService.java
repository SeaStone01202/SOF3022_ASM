package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.entity.AppUser;
import com.springboot.asm.fpoly_asm_springboot.entity.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);

    void deleteUser(int id);

    User updateUser(User user);

    User findUserById(int id);

    List<User> findAllUsers();

    AppUser findUserByEmail(String username);
}
