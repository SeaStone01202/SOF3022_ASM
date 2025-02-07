package com.springboot.asm.fpoly_asm_springboot.repositories.secondary;


import com.springboot.asm.fpoly_asm_springboot.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetail2Repository extends JpaRepository<OrderDetail, Integer> {

}
