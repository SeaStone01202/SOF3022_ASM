package com.springboot.asm.fpoly_asm_springboot.repositories.primary;

import com.springboot.asm.fpoly_asm_springboot.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Page<Review> findAll(Pageable pageable);

    Page<Review> findAllByProductId(Pageable pageable, Integer productId);

    Page<Review> findAllByUserId(Integer userId, Pageable pageable);
}
