package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.springboot.asm.fpoly_asm_springboot.dto.request.CategoryRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CategoryResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.mapper.CategoryMapper;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.CategoryRepository;
import com.springboot.asm.fpoly_asm_springboot.service.CategoryService;
import com.springboot.asm.fpoly_asm_springboot.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;
    private final PageUtil pageUtil;

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryResponse create(CategoryRequest request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new AppException(ErrorCode.CATEGORY_EXISTED);
        }
        Category category = categoryMapper.toCategory(request);
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public CategoryResponse update(Integer categoryId, CategoryRequest request) {

        Category categoryToUpdate = categoryRepository.findById(categoryId).orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED));

        categoryMapper.updateCategory(categoryToUpdate, request);

        return categoryMapper.toCategoryResponse(categoryRepository.save(categoryToUpdate));
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    public void delete(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    @Override
    public List<CategoryResponse> findAll() {

        var categoryList = categoryRepository.findAll();

        return categoryList.stream().map(categoryMapper::toCategoryResponse).toList();
    }

    @Override
    public CategoryResponse findById(int id) {
        return categoryMapper.toCategoryResponse(categoryRepository.findById(id).orElseThrow(() -> new AppException(ErrorCode.CATEGORY_NOT_EXISTED)));
    }

    @Override
    public List<CategoryResponse> findByName(String name) {
        return List.of();
    }

    @Override
    public Page<CategoryResponse> getPage(int page) {
        Pageable pageable = pageUtil.createPageable(page);
        return categoryRepository.findAll(pageable).map(categoryMapper::toCategoryResponse);
    }

}
