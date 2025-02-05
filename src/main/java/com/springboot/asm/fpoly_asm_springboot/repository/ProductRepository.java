package com.springboot.asm.fpoly_asm_springboot.repository;

import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
