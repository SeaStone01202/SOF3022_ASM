package com.springboot.asm.fpoly_asm_springboot.services.impl;


import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import com.springboot.asm.fpoly_asm_springboot.repositories.ProductRepository;
import com.springboot.asm.fpoly_asm_springboot.services.ProductService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ModelMapper modelMapper;
    private ProductRepository productRepository;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public ProductResponse create(Product product) {
        Product newProduct = productRepository.saveAndFlush(product);
        return modelMapper.map(newProduct, ProductResponse.class);
    }

    @Override
    public ProductResponse findById(int id) {
        Product product = productRepository.findById(id).orElse(null);
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();
        return modelMapper.map(products, new TypeToken<List<ProductResponse>>() {
        }.getType());
    }

    @Override
    public ProductResponse update(Product product) {
        if (productRepository.findById(product.getId()).isPresent()) {
            return null;
        }
        Product newProduct = productRepository.saveAndFlush(product);
        return modelMapper.map(newProduct, ProductResponse.class);
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
