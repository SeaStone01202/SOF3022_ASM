package com.springboot.asm.fpoly_asm_springboot.repositories;

import com.springboot.asm.fpoly_asm_springboot.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
