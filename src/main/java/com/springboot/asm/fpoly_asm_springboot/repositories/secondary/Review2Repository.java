package com.springboot.asm.fpoly_asm_springboot.repositories.secondary;

import com.springboot.asm.fpoly_asm_springboot.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Review2Repository extends JpaRepository<Review, Integer> {
}
