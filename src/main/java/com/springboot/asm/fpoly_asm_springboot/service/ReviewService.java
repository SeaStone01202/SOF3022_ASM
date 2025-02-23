package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.entity.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    Review save(Review review);

    Review update(Review review);

    Review delete(Integer id);

    Optional<Review> findById(Integer id);

    List<Review> findByUserId(Integer userId);

    List<Review> findByProductId(Integer productId);

}

