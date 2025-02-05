package com.springboot.asm.fpoly_asm_springboot.repositories;

import com.springboot.asm.fpoly_asm_springboot.entities.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Integer> {
}
