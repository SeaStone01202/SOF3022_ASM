package com.springboot.asm.fpoly_asm_springboot.services.impl;

import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.CategoryRepository;
import com.springboot.asm.fpoly_asm_springboot.services.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category create(Category category) {
       if(categoryRepository.existsByName(category.getName())) {
           return null;
       }
       return categoryRepository.save(category);
    }

    @Override
    public Category update(Category category) {
        return null;
    }

    @Override
    public Category delete(Category category) {
        return null;
    }

    @Override
    public List<Category> findAll() {
        return List.of();
    }

    @Override
    public Category findById(int id) {
        return null;
    }

    @Override
    public List<Category> findByName(String name) {
        return List.of();
    }
}
