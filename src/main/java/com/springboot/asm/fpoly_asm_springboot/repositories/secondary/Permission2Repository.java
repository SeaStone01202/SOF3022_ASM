package com.springboot.asm.fpoly_asm_springboot.repositories.secondary;

import com.springboot.asm.fpoly_asm_springboot.entity.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Permission2Repository extends JpaRepository<Permission, String> {
}
