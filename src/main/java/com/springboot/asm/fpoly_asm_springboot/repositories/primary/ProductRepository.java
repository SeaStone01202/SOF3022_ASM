package com.springboot.asm.fpoly_asm_springboot.repositories.primary;

import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Boolean existsByName(String name);

    Optional<Product> findByName(String name);
}
