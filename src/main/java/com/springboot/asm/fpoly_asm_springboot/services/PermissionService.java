package com.springboot.asm.fpoly_asm_springboot.services;

import com.springboot.asm.fpoly_asm_springboot.dto.request.PermissionRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {

    PermissionResponse create(PermissionRequest permissionRequest);

    List<PermissionResponse> getAll();

    void delete(String permission);
}
