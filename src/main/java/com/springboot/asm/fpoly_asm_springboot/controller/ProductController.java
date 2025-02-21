package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductResponse;
import com.springboot.asm.fpoly_asm_springboot.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.Arrays;
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

//    @GetMapping
//    ApiResponse<List<ProductResponse>> getAllProducts() {
//        return ApiResponse.<List<ProductResponse>>builder().
//                result(productService.findAll()).
//                build();
//    }

    @GetMapping
    public ApiResponse<List<ProductResponse>> getAllProducts() {
        // Dữ liệu sản phẩm giả lập
        List<ProductResponse> products = Arrays.asList(
                new ProductResponse(1, "SWE Basic Tee", "SWE", "Áo thun cotton 100%, thoáng mát và thoải mái",
                        "https://product.hstatic.net/1000344185/product/1_hong_75b7d03b8da143ff827d0061e5a35384_master.jpg", 250000f, "A4", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 101),
                new ProductResponse(2, "Oversized Tee", "SWE", "Áo thun form rộng, phù hợp streetwear",
                        "https://product.hstatic.net/1000344185/product/1__19__aa8e810b0ea3421799b73efcaf9e243b_master.jpg", 300000f, "A5", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 102),
                new ProductResponse(3, "SWE Cargo Pants", "SWE", "Quần cargo túi hộp, chất liệu kaki cao cấp",
                        "https://product.hstatic.net/1000344185/product/swe0723_30840dd25bff48cbad1c564e6da63720_master.jpg", 450000f, "B5", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()), 103)
        );

        return ApiResponse.<List<ProductResponse>>builder()
                .result(products)
                .build();
    }

    @GetMapping("/all")
    ApiResponse<List<ProductResponse>> getAllProductss() {
        return ApiResponse.<List<ProductResponse>>builder().
                result(productService.findAlls()).
                build();
    }

    @GetMapping("/search/category/{categoryId}")
    public Page<ProductResponse> getAllProductsByCategory(@PathVariable int categoryId
            , @RequestParam int pageNum) {
        return productService.findAllByCategoryId(categoryId, pageNum);
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

    @PostMapping("/upload-image/{productId}")
    ApiResponse<?> uploadImageProduct(@PathVariable Integer productId, @RequestParam MultipartFile image) {
        productService.uploadImage(productId, image);
        return ApiResponse.<String>builder()
                .result("Upload product image successfully")
                .build();
    }
}
