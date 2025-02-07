package com.springboot.asm.fpoly_asm_springboot.services.impl;

import com.springboot.asm.fpoly_asm_springboot.dto.request.PermissionRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.PermissionResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Permission;
import com.springboot.asm.fpoly_asm_springboot.mapper.PermissionMapper;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.PermissionRepository;
import com.springboot.asm.fpoly_asm_springboot.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImp implements PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public PermissionResponse create(PermissionRequest permissionRequest) {

        Permission permission = permissionMapper.toPermission(permissionRequest);

        return permissionMapper.toPermissionResponse(permissionRepository.save(permission));
    }

    @Override
    public List<PermissionResponse> getAll() {

        var permissions = permissionRepository.findAll();

        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
    }

    @Override
    public void delete(String permission) {
        permissionRepository.deleteById(permission);
    }
}
