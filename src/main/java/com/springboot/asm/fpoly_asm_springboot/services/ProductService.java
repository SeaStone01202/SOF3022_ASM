package com.springboot.asm.fpoly_asm_springboot.services;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductCreationRequest product);
    ProductResponse findById(int id);
    List<ProductResponse> findAll();
    ProductResponse update(Integer productId, ProductUpdatedRequest product);
    void delete(int id);
    List<ProductResponse> findAlls();
    void uploadImage(Integer productId, MultipartFile imageFile);
}
