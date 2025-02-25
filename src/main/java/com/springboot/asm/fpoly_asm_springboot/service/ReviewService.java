package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ReviewRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ReviewResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Review;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface ReviewService {

    ReviewResponse create(ReviewRequest request);

    Review update(Review review);

    Review delete(Integer id);

    Page<ReviewResponse> findAll(int page);

    Optional<Review> findById(Integer id);

    Page<Review> findByUserId(Integer userId,int page);

    Page<ReviewResponse> findByProductId(Integer productId, int page);

}

