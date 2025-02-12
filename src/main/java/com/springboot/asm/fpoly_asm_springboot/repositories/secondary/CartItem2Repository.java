package com.springboot.asm.fpoly_asm_springboot.repositories.secondary;

import com.springboot.asm.fpoly_asm_springboot.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItem2Repository extends JpaRepository<CartItem, Integer> {
}
