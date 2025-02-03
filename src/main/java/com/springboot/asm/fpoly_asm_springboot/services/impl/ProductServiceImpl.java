package com.springboot.asm.fpoly_asm_springboot.services.impl;

import com.springboot.asm.fpoly_asm_springboot.dto.ProductDTO;
import com.springboot.asm.fpoly_asm_springboot.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ProductServiceImpl implements ProductService {


    @Override
    public Page<ProductDTO> getProducts(Pageable pageable) {
        Page<ProductDTO> productDTOS = null;
        return null;
    }

    @Override
    public List<ProductDTO> getFeatureProducts() {
        return List.of();
    }

    @Override
    public Integer saveProduct(ProductDTO productDTO, MultipartFile file) {
        return 0;
    }

    @Override
    public Page<ProductDTO> getAllProductsByCategory(Integer category, int page, int size, String sort) {
        return null;
    }

    @Override
    public void removeProduct(Integer id) {

    }

    @Override
    public ProductDTO updateProduct(Integer id, ProductDTO productDTO, MultipartFile file) {
        return null;
    }

    @Override
    public ProductDTO getProduct(Integer id) {
        return null;
    }

    @Override
    public Long countProducts() {
        return 0L;
    }

    @Override
    public Page<ProductDTO> findProductsLikeProductName(String productName, Pageable pageable) {
        return null;
    }

    @Override
    public void updateQuantityProduct(Integer id, Integer quantity) {

    }
}
