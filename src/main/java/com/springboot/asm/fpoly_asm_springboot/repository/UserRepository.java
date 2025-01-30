package com.springboot.asm.fpoly_asm_springboot.repository;

import com.springboot.asm.fpoly_asm_springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByEmail(String email);
}