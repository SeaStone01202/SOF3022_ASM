package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ReviewRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ReviewResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ReviewService {

    ReviewResponse create(ReviewRequest request);

    Review update(Review review);

    Review delete(Integer id);

    Page<ReviewResponse> findAll(int page);

    Optional<Review> findById(Integer id);

    List<Review> findByUserId(Integer userId);

    List<Review> findByProductId(Integer productId);

}

