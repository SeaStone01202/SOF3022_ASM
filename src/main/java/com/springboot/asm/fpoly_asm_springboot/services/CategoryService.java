package com.springboot.asm.fpoly_asm_springboot.services;

import com.springboot.asm.fpoly_asm_springboot.entity.Category;

import java.util.List;

public interface CategoryService {
    Category create(Category category);
    Category update(Category category);
    Category delete(Category category);
    List<Category> findAll();
    Category findById(int id);
    List<Category> findByName(String name);
}
