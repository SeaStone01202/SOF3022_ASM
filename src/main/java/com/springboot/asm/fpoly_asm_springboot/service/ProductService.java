package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    Page<ProductDTO> getProducts(Pageable pageable);

    List<ProductDTO> getFeatureProducts();

    Integer saveProduct(ProductDTO productDTO, MultipartFile file);

    Page<ProductDTO> getAllProductsByCategory(Integer category, int page, int size, String sort);

    void removeProduct(Integer id);

    ProductDTO updateProduct(Integer id, ProductDTO productDTO, MultipartFile file);

    ProductDTO getProduct(Integer id);

    Long countProducts();

    Page<ProductDTO> findProductsLikeProductName(String productName, Pageable pageable);

    void updateQuantityProduct(Integer id, Integer quantity);
}
