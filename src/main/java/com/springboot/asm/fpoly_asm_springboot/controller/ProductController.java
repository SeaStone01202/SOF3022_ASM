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

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Tạo sản phẩm mới
    @PostMapping
    public ApiResponse<ProductResponse> createProduct(@RequestBody ProductCreationRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.create(request))
                .build();
    }

    // Lấy tất cả sản phẩm với phân trang
    @GetMapping
    public Page<ProductResponse> getAllProducts(@RequestParam int page) {
        return productService.findAll(page);
    }

    // Lấy sản phẩm theo danh mục
    @GetMapping("/search/category/{categoryId}")
    public Page<ProductResponse> getAllProductsByCategory(@PathVariable int categoryId,
                                                          @RequestParam int pageNum) {
        return productService.findAllByCategoryId(categoryId, pageNum);
    }

    // Lấy sản phẩm theo khoảng giá toàn cục
    @GetMapping("/search/price")
    public Page<ProductResponse> getProductsByPriceRange(@RequestParam float priceMin,
                                                         @RequestParam float priceMax,
                                                         @RequestParam int pageNum) {
        return productService.findByPriceRange(priceMin, priceMax, pageNum);
    }

    // Lấy sản phẩm theo danh mục và khoảng giá
    @GetMapping("/search/category/{categoryId}/price")
    public Page<ProductResponse> getProductsByCategoryAndPrice(@PathVariable int categoryId,
                                                               @RequestParam float priceMin,
                                                               @RequestParam float priceMax,
                                                               @RequestParam int pageNum) {
        var products = productService.findByCategoryAndPrice(categoryId, priceMin, priceMax, pageNum);
        return products;
    }

    // Lấy sản phẩm theo danh mục và kích thước
    @GetMapping("/search/category/{categoryId}/size")
    public Page<ProductResponse> getProductsByCategoryAndSize(@PathVariable int categoryId,
                                                              @RequestParam String size,
                                                              @RequestParam int pageNum) {
        return productService.findByCategoryAndSize(categoryId, size, pageNum);
    }

    // Lấy sản phẩm theo danh mục, kích thước và khoảng giá
    @GetMapping("/search/category/{categoryId}/filter")
    public Page<ProductResponse> getProductsByCategorySizeAndPrice(@PathVariable int categoryId,
                                                                   @RequestParam String size,
                                                                   @RequestParam float priceMin,
                                                                   @RequestParam float priceMax,
                                                                   @RequestParam int pageNum) {
        return productService.findByCategorySizeAndPrice(categoryId, size, priceMin, priceMax, pageNum);
    }

    // Lấy sản phẩm sắp xếp theo tên A-Z (toàn cục hoặc bạn có thể mở rộng thêm theo danh mục nếu cần)
    @GetMapping("/sort/name/asc/{categoryId}")
    public Page<ProductResponse> getProductsSortedByNameAsc(@PathVariable Integer categoryId, @RequestParam int pageNum) {
        return productService.findAllSortedByNameAsc(categoryId, pageNum);
    }

    // Lấy sản phẩm sắp xếp theo tên Z-A
    @GetMapping("/sort/name/desc/{categoryId}")
    public Page<ProductResponse> getProductsSortedByNameDesc(@PathVariable Integer categoryId, @RequestParam int pageNum) {
        return productService.findAllSortedByNameDesc(categoryId, pageNum);
    }

    // Lấy sản phẩm theo danh mục và sắp xếp theo giá tăng dần
    @GetMapping("/search/category/{categoryId}/sort/price/asc")
    public Page<ProductResponse> getProductsByCategoryAndPriceAsc(@PathVariable int categoryId,
                                                                  @RequestParam int pageNum) {
        return productService.findByCategoryIdOrderByPriceAsc(pageNum, categoryId);
    }

    // Lấy sản phẩm theo danh mục và sắp xếp theo giá giảm dần
    @GetMapping("/search/category/{categoryId}/sort/price/desc")
    public Page<ProductResponse> getProductsByCategoryAndPriceDesc(@PathVariable int categoryId,
                                                                   @RequestParam int pageNum) {
        return productService.findByCategoryIdOrderByPriceDesc(pageNum, categoryId);
    }

    // Lấy thông tin chi tiết sản phẩm
    @GetMapping("/{productId}")
    public ApiResponse<ProductResponse> getProduct(@PathVariable Integer productId) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.findById(productId))
                .build();
    }

    // Cập nhật sản phẩm
    @PutMapping("/{productId}")
    public ApiResponse<ProductResponse> updateProduct(@PathVariable Integer productId,
                                                      @RequestBody ProductUpdatedRequest request) {
        return ApiResponse.<ProductResponse>builder()
                .result(productService.update(productId, request))
                .build();
    }

    // Xóa sản phẩm
    @DeleteMapping("/{productId}")
    public ApiResponse<String> deleteProduct(@PathVariable Integer productId) {
        productService.delete(productId);
        return ApiResponse.<String>builder()
                .result("Product deleted")
                .build();
    }

    // Upload hình ảnh cho sản phẩm
    @PostMapping("/upload-image/{productId}")
    public ApiResponse<?> uploadImageProduct(@PathVariable Integer productId, @RequestParam MultipartFile image) {
        productService.uploadImage(productId, image);
        return ApiResponse.<String>builder()
                .result("Upload product image successfully")
                .build();
    }
}
