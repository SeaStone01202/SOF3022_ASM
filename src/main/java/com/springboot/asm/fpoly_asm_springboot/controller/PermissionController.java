package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.PermissionRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.PermissionResponse;
import com.springboot.asm.fpoly_asm_springboot.services.PermissionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    ApiResponse<PermissionResponse> createPermission(@RequestBody PermissionRequest permissionRequest) {
        return ApiResponse.<PermissionResponse>builder().
                result(permissionService.create(permissionRequest)).
                build();
    }

    @GetMapping
    ApiResponse<List<PermissionResponse>> getPermissions() {
        return ApiResponse.<List<PermissionResponse>>builder().
                result(permissionService.getAll()).
                build();
    }

    @DeleteMapping("/{permission}")
    public ApiResponse<String> deletePermission(@PathVariable("permission") String permission) {
        permissionService.delete(permission);
        return ApiResponse.<String>builder().
                result("Permission has been deleted").
                build();
    }
}
