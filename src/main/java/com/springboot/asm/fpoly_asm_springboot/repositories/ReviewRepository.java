package com.springboot.asm.fpoly_asm_springboot.repositories;

import com.springboot.asm.fpoly_asm_springboot.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
}
