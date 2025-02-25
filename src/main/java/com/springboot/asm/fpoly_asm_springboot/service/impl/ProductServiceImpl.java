package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductCreationRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductUpdatedRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.mapper.ProductMapper;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.CategoryRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.ProductRepository;
import com.springboot.asm.fpoly_asm_springboot.service.ProductService;
import com.springboot.asm.fpoly_asm_springboot.service.UploadImageFileService;
import com.springboot.asm.fpoly_asm_springboot.util.PageUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProductMapper productMapper;
    private final UploadImageFileService uploadImageFileService;
    private final PageUtil pageUtil;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse create(ProductCreationRequest request) {

        if (productRepository.existsByName(request.getName())) {
            throw new AppException(ErrorCode.PRODUCT_ALREADY_EXISTED);
        }

        Product product = productMapper.toProduct(request);
        product.setPublishDate(Date.valueOf(LocalDate.now()));
        product.setLastUpdateTime(Date.valueOf(LocalDate.now()));
        product.setCategory(getCategoryById(request.getCategoryId()));

        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    public ProductResponse findById(int id) {
        return productMapper.toProductResponse(
                productRepository.findById(id)
                        .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED))
        );
    }

    @Override
    public Page<ProductResponse> findAll(int page) {
        Pageable pageable = pageUtil.createPageable(page);
        return productRepository.findAll(pageable)
                .map(productMapper::toProductResponse);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public ProductResponse update(Integer productId, ProductUpdatedRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

        product.setLastUpdateTime(Date.valueOf(LocalDate.now()));
        product.setCategory(getCategoryById(request.getCategoryId()));
        productMapper.updateProduct(product, request);
        return productMapper.toProductResponse(productRepository.save(product));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(int id) {
        productRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<ProductResponse> findAlls() {
        List<Product> products = productRepository.findAll();
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            productResponses.add(productMapper.toProductResponse(product));
        }
        return productResponses;
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void uploadImage(Integer productId, MultipartFile imageFile) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

        product.setLastUpdateTime(Date.valueOf(LocalDate.now()));
        product.setImage(convertImageToStringUrl(imageFile));
        productRepository.save(product);
    }

    @Override
    public Page<ProductResponse> findAllByCategoryId(int categoryId, int pageNum) {
        Pageable pageable = pageUtil.createPageable(pageNum);
        return productRepository.findByCategoryId(categoryId, pageable)
                .map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> findByPriceRange(float priceMin, float priceMax, int pageNum) {
        Pageable pageable = pageUtil.createPageable(pageNum);
        return productRepository.findAllByPriceBetween(priceMin, priceMax, pageable)
                .map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> findByCategoryAndPrice(int categoryId, float priceMin, float priceMax, int pageNum) {
        Pageable pageable = pageUtil.createPageable(pageNum);
        return productRepository.findByCategoryIdAndPriceBetween(categoryId, priceMin, priceMax, pageable)
                .map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> findByCategoryAndSize(int categoryId, String size, int pageNum) {
        Pageable pageable = pageUtil.createPageable(pageNum);
        return productRepository.findByCategoryIdAndSize(categoryId, size, pageable)
                .map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> findByCategorySizeAndPrice(int categoryId, String size, float priceMin, float priceMax, int pageNum) {
        Pageable pageable = pageUtil.createPageable(pageNum);
        return productRepository.findByCategoryIdAndSizeAndPriceBetween(categoryId, size, priceMin, priceMax, pageable)
                .map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> findAllSortedByNameAsc(int pageNum, Integer categoryId) {
        Pageable pageable = pageUtil.createPageable(pageNum);
        return productRepository.findByCategoryIdOrderByNameAsc(categoryId, pageable).map(productMapper::toProductResponse);
    }

    @Override
    public Page<ProductResponse> findAllSortedByNameDesc(int pageNum, Integer categoryId) {
        Pageable pageable = pageUtil.createPageable(pageNum);
        return productRepository.findByCategoryIdOrderByNameDesc(categoryId, pageable).map(productMapper::toProductResponse);
    }
///
    @Override
    public Page<ProductResponse> findByCategoryIdOrderByPriceAsc(int pageNum, Integer categoryId) {
        Pageable pageable = pageUtil.createPageable(pageNum);
        return productRepository.findByCategoryIdOrderByPriceAsc(categoryId, pageable).map(productMapper::toProductResponse);
    }
///
    @Override
    public Page<ProductResponse> findByCategoryIdOrderByPriceDesc(int pageNum, Integer categoryId) {
        Pageable pageable = pageUtil.createPageable(pageNum);
        return productRepository.findByCategoryIdOrderByPriceDesc(categoryId, pageable).map(productMapper::toProductResponse);
    }

    private Category getCategoryById(Integer id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));
    }

    private String convertImageToStringUrl(MultipartFile file) {
        return uploadImageFileService.uploadImageFile(file);
    }
}
