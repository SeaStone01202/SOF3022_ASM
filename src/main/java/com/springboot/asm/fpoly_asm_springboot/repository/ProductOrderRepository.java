package com.springboot.asm.fpoly_asm_springboot.repository;

import com.springboot.asm.fpoly_asm_springboot.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
