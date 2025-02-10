package com.springboot.asm.fpoly_asm_springboot.repositories.primary;

import com.springboot.asm.fpoly_asm_springboot.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, String> {
}
