package com.springboot.asm.fpoly_asm_springboot.repositories;

import com.springboot.asm.fpoly_asm_springboot.entity.Permission;
import com.springboot.asm.fpoly_asm_springboot.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
}
