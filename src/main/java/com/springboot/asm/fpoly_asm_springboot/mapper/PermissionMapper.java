package com.springboot.asm.fpoly_asm_springboot.mapper;


import com.springboot.asm.fpoly_asm_springboot.dto.request.PermissionRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.RoleRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.PermissionResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.RoleResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Permission;
import com.springboot.asm.fpoly_asm_springboot.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    Permission toPermission(PermissionRequest permissionRequest);

    PermissionResponse toPermissionResponse(Permission permission);
}
