package com.springboot.asm.fpoly_asm_springboot.services.impl;

import com.springboot.asm.fpoly_asm_springboot.entities.User;
import com.springboot.asm.fpoly_asm_springboot.repositories.UserRepository;
import com.springboot.asm.fpoly_asm_springboot.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User findUserById(int id) {
        User user = new User();
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return List.of();
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
