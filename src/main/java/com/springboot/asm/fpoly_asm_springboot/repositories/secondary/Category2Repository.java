package com.springboot.asm.fpoly_asm_springboot.repositories.secondary;


import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Category2Repository extends JpaRepository<Category, Integer> {
    Category findByName(String name);
    Category findById(int id);
    Boolean existsByName(String name);
}
