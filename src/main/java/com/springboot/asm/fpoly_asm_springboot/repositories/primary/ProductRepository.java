package com.springboot.asm.fpoly_asm_springboot.repositories.primary;

import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Boolean existsByName(String name);

    Optional<Product> findByName(String name);

    Page<Product> findAll(Pageable pageable);

    Page<Product> findByCategoryId(Integer categoryId, Pageable pageable);

    Page<Product> findAllByPriceBetween(Float priceMin, Float priceMax, Pageable pageable);

    Page<Product> findByCategoryIdAndPriceBetween(Integer categoryId, Float priceMin, Float priceMax, Pageable pageable);

    Page<Product> findByCategoryIdAndSize(Integer categoryId, String size, Pageable pageable);

    Page<Product> findByCategoryIdAndSizeAndPriceBetween(Integer categoryId, String size, Float priceMin, Float priceMax, Pageable pageable);

    Page<Product> findByCategoryIdOrderByPriceAsc(Integer categoryId, Pageable pageable);

    Page<Product> findByCategoryIdOrderByPriceDesc(Integer categoryId, Pageable pageable);

    Page<Product> findByCategoryIdOrderByNameAsc(Integer categoryId, Pageable pageable);

    Page<Product> findByCategoryIdOrderByNameDesc(Integer categoryId, Pageable pageable);
}
