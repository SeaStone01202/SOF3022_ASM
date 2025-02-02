package com.poly.service.implement;

import com.poly.dto.request.UserCreationRequest;
import com.poly.dto.request.UserUpdatedRequest;
import com.poly.dto.response.UserResponse;
import com.poly.enity.User;
import com.poly.enums.Role;
import com.poly.exception.AppException;
import com.poly.exception.ErrorCode;
import com.poly.mapper.UserMapper;
import com.poly.repository.UserRepository;
import com.poly.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserResponse createUser(UserCreationRequest request) {
        if( userRepository.existsByUsername(request.getUsername()) ) {
            throw new AppException(ErrorCode.USER_EXISTED);
        }
        User user = userMapper.toUser(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        HashSet<String> roles = new HashSet<>();
        roles.add(Role.USER.name());
        user.setRoles(roles);
        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserResponse getUserById(String id) {
        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found")));
    }

    @Override
    public UserResponse updateUser(String userId, UserUpdatedRequest request) {
        User userUpdating = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User with id " + userId + " not found"));
        userMapper.updateUser(userUpdating, request);
        return userMapper.toUserResponse(userRepository.save(userUpdating));
    }

    @Override
    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

}
