package com.springboot.asm.fpoly_asm_springboot.mapper;


import com.springboot.asm.fpoly_asm_springboot.dto.request.RoleRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.RoleResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.UserResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Role;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions" , ignore = true)
    Role toRole(RoleRequest roleRequest);

    RoleResponse toRoleResponse(Role role);
}
