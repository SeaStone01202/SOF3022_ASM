package com.springboot.asm.fpoly_asm_springboot.services;

import com.springboot.asm.fpoly_asm_springboot.entity.Product;

import java.util.List;

public interface ProductService {

    Product create(Product product);
    Product findById(int id);
    List<Product> findAll();
    Product update(Product product);
    Boolean delete(int id);
    
}
