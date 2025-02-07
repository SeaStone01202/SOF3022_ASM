package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.UserUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import com.springboot.asm.fpoly_asm_springboot.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    
    @PostMapping
    ApiResponse<ProductResponse> createProduct(@RequestBody ProductCreationRequest request) {

        return ApiResponse.<ProductResponse>builder().
                result(productService.create(request)).
                build();
    }

    @GetMapping
    ApiResponse<List<ProductResponse>> getAllProducts() {
        return ApiResponse.<List<ProductResponse>>builder().
                result(productService.findAll()).
                build();
    }
    @GetMapping("/all")
    ApiResponse<List<ProductResponse>> getAllProductss() {
        return ApiResponse.<List<ProductResponse>>builder().
                result(productService.findAlls()).
                build();
    }

    @GetMapping("/{productId}")
    ApiResponse<ProductResponse> getProduct(@PathVariable Integer productId) {
        return ApiResponse.<ProductResponse>builder().
                result(productService.findById(productId)).
                build();
    }

    @PutMapping("/{productId}")
    ApiResponse<ProductResponse> updateProduct(@PathVariable Integer productId, @RequestBody ProductUpdatedRequest request) {
        return ApiResponse.<ProductResponse>builder().
                result(productService.update(productId, request)).
                build();
    }

    @DeleteMapping("/{productId}")
    ApiResponse<String> deleteProduct(@PathVariable Integer productId) {
        productService.delete(productId);
        return ApiResponse.<String>builder().
                result("Product deleted").
                build();
    }
}
