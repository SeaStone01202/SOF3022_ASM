package com.springboot.asm.fpoly_asm_springboot.services.impl;

import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import com.springboot.asm.fpoly_asm_springboot.repositories.ProductRepository;
import com.springboot.asm.fpoly_asm_springboot.services.ProductService;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ModelMapper modelMapper;
    private ProductRepository productRepository;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public Product create(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);

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
