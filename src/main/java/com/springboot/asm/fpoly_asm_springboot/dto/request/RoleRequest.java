package com.springboot.asm.fpoly_asm_springboot.dto.request;

import com.springboot.asm.fpoly_asm_springboot.dto.response.PermissionResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RoleRequest {
    String name;
    String description;
    Set<PermissionResponse> permissions;
}
