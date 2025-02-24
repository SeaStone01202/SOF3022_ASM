package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.CategoryRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CategoryResponse;
import com.springboot.asm.fpoly_asm_springboot.service.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @PostMapping
    ApiResponse<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {

        return ApiResponse.<CategoryResponse>builder().
                result(categoryService.create(request)).
                build();
    }

    @GetMapping
    ApiResponse<List<CategoryResponse>> getAllCategories() {
        return ApiResponse.<List<CategoryResponse>>builder().
                result(categoryService.findAll()).
                build();
    }

    @GetMapping("/{categoryId}")
    ApiResponse<CategoryResponse> getCategory(@PathVariable Integer categoryId) {
        return ApiResponse.<CategoryResponse>builder().
                result(categoryService.findById(categoryId)).
                build();
    }

    @PutMapping("/{categoryId}")
    ApiResponse<CategoryResponse> updateCategory(@PathVariable Integer categoryId, @RequestBody CategoryRequest request) {
        return ApiResponse.<CategoryResponse>builder().
                result(categoryService.update(categoryId, request)).
                build();
    }

    @DeleteMapping("/{categoryId}")
    ApiResponse<String> deleteUser(@PathVariable Integer categoryId) {
        categoryService.delete(categoryId);
        return ApiResponse.<String>builder().
                result("Category deleted").
                build();
    }

    @GetMapping("/pages")
    Page<CategoryResponse> getPages(@RequestParam int page) {
        return categoryService.getPage(page);
    }
}
