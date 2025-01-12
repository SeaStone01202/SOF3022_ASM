package com.springboot.asm.fpoly_asm_springboot.services;

import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Product;

import java.util.List;

public interface ProductService {

    ProductResponse create(Product product);
    ProductResponse findById(int id);
    List<ProductResponse> findAll();
    ProductResponse update(Product product);
    Boolean delete(int id);
    
}
