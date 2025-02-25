package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    ProductResponse create(ProductCreationRequest product);

    ProductResponse findById(int id);

    Page<ProductResponse> findAll(int page);

    ProductResponse update(Integer productId, ProductUpdatedRequest product);

    void delete(int id);

    List<ProductResponse> findAlls();

    void uploadImage(Integer productId, MultipartFile imageFile);

    // Lấy danh sách sản phẩm theo danh mục
    Page<ProductResponse> findAllByCategoryId(int categoryId, int pageNum);

    // Tìm kiếm theo khoảng giá
    Page<ProductResponse> findByPriceRange(float priceMin, float priceMax, int pageNum);

    // Lọc theo danh mục và khoảng giá
    Page<ProductResponse> findByCategoryAndPrice(int categoryId, float priceMin, float priceMax, int pageNum);

    // Lọc theo danh mục và kích thước
    Page<ProductResponse> findByCategoryAndSize(int categoryId, String size, int pageNum);

    // Lọc theo danh mục, kích thước và giá
    Page<ProductResponse> findByCategorySizeAndPrice(int categoryId, String size, float priceMin, float priceMax, int pageNum);

    // Sắp xếp theo tên A-Z
    Page<ProductResponse> findAllSortedByNameAsc(int pageNum,Integer categoryId);

    // Sắp xếp theo tên Z-A
    Page<ProductResponse> findAllSortedByNameDesc(int pageNum,Integer categoryId);

    Page<ProductResponse> findByCategoryIdOrderByPriceAsc(int pageNum,Integer categoryId);

    Page<ProductResponse> findByCategoryIdOrderByPriceDesc(int pageNum,Integer categoryId);
}
