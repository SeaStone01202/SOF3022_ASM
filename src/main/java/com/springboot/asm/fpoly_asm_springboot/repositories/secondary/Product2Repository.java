package com.springboot.asm.fpoly_asm_springboot.repositories.secondary;

import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Product2Repository extends JpaRepository<Product, Integer> {

    Boolean existsByName(String name);
}
