package com.springboot.asm.fpoly_asm_springboot.repositories.secondary;

import com.springboot.asm.fpoly_asm_springboot.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrder2Repository extends JpaRepository<ProductOrder, Integer> {
}
