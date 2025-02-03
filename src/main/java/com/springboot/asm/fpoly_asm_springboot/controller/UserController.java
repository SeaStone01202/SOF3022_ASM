package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.UserResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import com.springboot.asm.fpoly_asm_springboot.services.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    ApiResponse<UserResponse> createUser(@RequestBody @Valid UserCreationRequest request) {

        ApiResponse<UserResponse> userApiResponse = ApiResponse.<UserResponse>builder().result(userService.createUser(request)).build();

        return userApiResponse;
    }

    @GetMapping
    List<User> getAllUsers() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();

        log.info("Username: {}", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.info("GrantedAuthority: {}", grantedAuthority.getAuthority()));
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    UserResponse getUser(@PathVariable Integer userId) {

        return userService.getUserById(userId);
    }

    @PutMapping("/{userId}")
    UserResponse updateUser(@PathVariable Integer userId, @RequestBody UserUpdatedRequest request) {

        return userService.updateUser(userId, request);
    }

    @DeleteMapping("/{userId}")
    String deleteUser(@PathVariable Integer userId) {

        userService.deleteUser(userId);

        return "User deleted";
    }
}
