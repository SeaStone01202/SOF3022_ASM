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
import java.time.LocalDateTime;
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

    public void addData() {
        List<Category> categories = new ArrayList<>();
        categories.add(new Category( "Áo thun"));  // Để Hibernate tự tạo ID
        categories.add(new Category( "Quần jean"));
        categories.add(new Category( "Giày thể thao"));

        List<Category> savedCategories = categoryRepository.saveAll(categories);

        List<Product> products = new ArrayList<>();
        products.add(new Product("Áo thun trắng nam", "Áo thun nam chất liệu cotton thoáng mát", "https://res.cloudinary.com/dpbysnmcc/image/upload/sample.jpg", 299000, 100, "L", LocalDate.of(2025, 2, 20), LocalDateTime.of(2025, 2, 24, 0, 0), savedCategories.get(0)));
        products.add(new Product( "Áo thun đen nữ", "Áo thun nữ phong cách basic", "https://res.cloudinary.com/dpbysnmcc/image/upload/sample.jpg", 249000, 80, "M", LocalDate.of(2025, 2, 18), LocalDateTime.of(2025, 2, 23, 0, 0), savedCategories.get(0)));
        products.add(new Product( "Quần jean xanh nam", "Quần jean nam form slimfit, chất liệu co giãn", "https://res.cloudinary.com/dpbysnmcc/image/upload/sample.jpg", 699000, 50, "M", LocalDate.of(2025, 2, 19), LocalDateTime.of(2025, 2, 21, 0, 0), savedCategories.get(1)));
        products.add(new Product("Quần jean đen nữ", "Quần jean nữ dáng skinny, tôn dáng", "https://res.cloudinary.com/dpbysnmcc/image/upload/sample.jpg", 729000, 40, "S", LocalDate.of(2025, 2, 20), LocalDateTime.of(2025, 2, 22, 0, 0), savedCategories.get(1)));
        products.add(new Product( "Giày Adidas Ultraboost", "Giày thể thao nam chống trơn trượt", "https://res.cloudinary.com/dpbysnmcc/image/upload/sample.jpg", 1800000, 30, "L", LocalDate.of(2025, 2, 15), LocalDateTime.of(2025, 2, 24, 0, 0), savedCategories.get(2)));

        productRepository.saveAll(products);
    }
}
