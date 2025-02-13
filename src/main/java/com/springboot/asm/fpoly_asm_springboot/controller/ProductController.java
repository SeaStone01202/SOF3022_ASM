package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductResponse;
import com.springboot.asm.fpoly_asm_springboot.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Slf4j
@Tag(name = "Product API", description = "Quản lý sản phẩm")
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @Operation(summary = "Tạo sản phẩm mới", description = "API để tạo sản phẩm mới")
    @PostMapping
    ApiResponse<ProductResponse> createProduct(@RequestBody ProductCreationRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.create(request))
                .build();
    }

    @Operation(summary = "Lấy danh sách sản phẩm", description = "API để lấy toàn bộ danh sách sản phẩm")
    @GetMapping
    ApiResponse<List<ProductResponse>> getAllProducts() {
        return ApiResponse.<List<ProductResponse>>builder()
                .result(productService.findAll())
                .build();
    }

    @Operation(summary = "Lấy thông tin sản phẩm theo ID", description = "API lấy thông tin sản phẩm dựa vào ID")
    @GetMapping("/{productId}")
    ApiResponse<ProductResponse> getProduct(@PathVariable Integer productId) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.findById(productId))
                .build();
    }

    @Operation(summary = "Cập nhật sản phẩm", description = "API để cập nhật thông tin sản phẩm")
    @PutMapping("/{productId}")
    ApiResponse<ProductResponse> updateProduct(@PathVariable Integer productId, @RequestBody ProductUpdatedRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.update(productId, request))
                .build();
    }

    @Operation(summary = "Xóa sản phẩm", description = "API để xóa sản phẩm dựa vào ID")
    @DeleteMapping("/{productId}")
    ApiResponse<String> deleteProduct(@PathVariable Integer productId) {
        productService.delete(productId);
        return ApiResponse.<String>builder()
                .result("Product deleted")
                .build();
    }

    @Operation(summary = "Upload ảnh sản phẩm", description = "API để upload ảnh sản phẩm dựa vào ID")
    @PostMapping("/upload-image/{productId}")
    ApiResponse<?> uploadImageProduct(@PathVariable Integer productId, @RequestParam MultipartFile image) {
        productService.uploadImage(productId, image);
        return ApiResponse.<String>builder()
                .result("Upload product image successfully")
                .build();
    }
}
