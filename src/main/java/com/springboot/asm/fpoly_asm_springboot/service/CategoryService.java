package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.request.CategoryRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CategoryResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    CategoryResponse create(CategoryRequest category);
    CategoryResponse update(Integer categoryId,CategoryRequest category);
    void delete(Integer categoryId);
    List<CategoryResponse> findAll();
    CategoryResponse findById(int id);
    List<CategoryResponse> findByName(String name);
    Page<CategoryResponse> getPage(  int page);
}
