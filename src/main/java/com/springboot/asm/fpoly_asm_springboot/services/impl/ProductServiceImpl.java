package com.springboot.asm.fpoly_asm_springboot.services.impl;

import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.repositories.ProductRepository;
import com.springboot.asm.fpoly_asm_springboot.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        if (productRepository.existsById(product.getId())) {
            throw new AppException(ErrorCode.PRODUCT_ALREADY_EXISTED);
        }
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();

    }

    @Override
    public Product update(Product product) {
        if (productRepository.findById(product.getId()).isPresent()) {
            return null;
        }
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Boolean delete(int id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            return false;
        }
        productRepository.delete(product);
        return true;
    }
}
