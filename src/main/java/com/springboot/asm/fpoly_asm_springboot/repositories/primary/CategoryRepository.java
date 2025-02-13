package com.springboot.asm.fpoly_asm_springboot.repositories.primary;


import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import jakarta.validation.constraints.Size;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByName(String name);
    Optional<Category> findById(int id);
    Boolean existsByName(String name);

    Page<Category> pagination(Pageable pageable);
}
