package com.springboot.asm.fpoly_asm_springboot.services.impl;

import com.springboot.asm.fpoly_asm_springboot.dto.request.UserRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.UserResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import com.springboot.asm.fpoly_asm_springboot.repositories.UserRepository;
import com.springboot.asm.fpoly_asm_springboot.services.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponse create(UserRequest userRequest) {
        User user = new User();
        User userCreated = userRepository.saveAndFlush(user);
        UserResponse userResponse = modelMapper.map(userCreated, UserResponse.class);
        return userResponse;
    }

    @Override
    public UserResponse update(UserRequest userRequest) {
        User userUpdating = userRepository.findByEmail(userRequest.email());
        if (userUpdating == null) {
            return null;
        }
        User userUpdated = userRepository.saveAndFlush(userUpdating);
        UserResponse userResponse = modelMapper.map(userUpdated, UserResponse.class);
        return userResponse;
    }

    @Override
    public Boolean delete(UserRequest userRequest) {
        User userDeleting = userRepository.findByEmail(userRequest.email());
        if (userDeleting == null) {
            return false;
        }
        userRepository.delete(userDeleting);
        return true;
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.findAll();
        return modelMapper.map(users, new TypeToken<List<UserResponse>>() {
        }.getType());
    }
}
