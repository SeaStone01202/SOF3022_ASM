package com.springboot.asm.fpoly_asm_springboot.repositories.primary;

import com.springboot.asm.fpoly_asm_springboot.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    List<CartItem> findByUserEmail(String user_email);
    void deleteByUserId(Integer userId);
}
