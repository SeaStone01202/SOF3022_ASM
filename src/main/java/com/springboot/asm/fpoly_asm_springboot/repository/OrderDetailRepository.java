package com.springboot.asm.fpoly_asm_springboot.repository;

import com.springboot.asm.fpoly_asm_springboot.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
