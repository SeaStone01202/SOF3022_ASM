package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.springboot.asm.fpoly_asm_springboot.constant.Role;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.UserResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.mapper.UserMapper;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.UserRepository;
import com.springboot.asm.fpoly_asm_springboot.service.UploadImageFileService;
import com.springboot.asm.fpoly_asm_springboot.service.UserService;
import com.springboot.asm.fpoly_asm_springboot.util.PageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UploadImageFileService uploadImageFileService;
    private final PageUtil pageUtil;


    @Override
    public UserResponse createUser(UserCreationRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {

            throw new AppException(ErrorCode.USER_EXISTED);

        }
        User user = userMapper.toUser(request);

        String fullName = request.getLastName() + " " + request.getFirstName();

        user.setFullName(fullName);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.setRole(Role.USER);

        return userMapper.toUserResponse(userRepository.save(user));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public Page<UserResponse> getUsers(int page) {

        Pageable pageable = pageUtil.createPageable(page);

        return userRepository.findAll(pageable).map(userMapper::toUserResponse);
    }

    @Override
    public UserResponse getMyInfo() {

        var context = SecurityContextHolder.getContext();

        String email = context.getAuthentication().getName();

        User user = userRepository.findByEmail(email)

                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        return userMapper.toUserResponse(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
    }

    @Override
    @PostAuthorize("returnObject.email == authentication.name")
    public UserResponse getUserById(Integer id) {

        return userMapper.toUserResponse(userRepository.findById(id)

                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)));

    }

    @Override
    @PostAuthorize("returnObject.email == authentication.name")
    public UserResponse updateUser(Integer userId, UserUpdatedRequest request) {

        User userUpdating = userRepository.findById(userId).
                orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        userMapper.updateUser(userUpdating, request);

        return userMapper.toUserResponse(userRepository.save(userUpdating));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public void uploadAvatar(Integer userId, MultipartFile file) {

        var authUserEmail = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        User user = userRepository.findById(userId)

                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        if (!authUserEmail.equals(user.getEmail())) {

            log.error("Logged user is: {} try to upload avatar", authUserEmail);

            log.error("User email have permission is: {}", user.getEmail());

            throw new AppException(ErrorCode.AVATAR_NOT_PERMISSION);
        }

        String avatarUrl = uploadImageFileService.uploadImageFile(file);

        user.setAvatar(avatarUrl);

        userRepository.save(user);
    }

    @Override
    public void updatePassword(String email, String newPassword) {
        User userResetPassword = userRepository.findByEmail(email)

                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        String oldPassword = userResetPassword.getPassword();

        if (!passwordEncoder.matches(oldPassword, newPassword)) {

            userResetPassword.setPassword(passwordEncoder.encode(newPassword));

            userRepository.save(userResetPassword);

        } else throw new AppException(ErrorCode.PASSWORD_INVALID);
    }
}
