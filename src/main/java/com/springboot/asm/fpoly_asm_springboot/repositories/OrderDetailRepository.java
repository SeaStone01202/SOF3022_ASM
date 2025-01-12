package com.springboot.asm.fpoly_asm_springboot.repositories;


import com.springboot.asm.fpoly_asm_springboot.entity.OrderDetail;
import com.springboot.asm.fpoly_asm_springboot.entity.OrderDetailKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailKey> {

}
