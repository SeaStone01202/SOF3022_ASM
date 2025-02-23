package com.springboot.asm.fpoly_asm_springboot.service.impl;


import com.springboot.asm.fpoly_asm_springboot.entity.Review;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.ReviewRepository;
import com.springboot.asm.fpoly_asm_springboot.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return null;
    }

    @Override
    public Review update(Review review) {
        return null;
    }

    @Override
    public Review delete(Integer id) {
        return null;
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return reviewRepository.findById(id);
    }

    @Override
    public List<Review> findByUserId(Integer userId) {
        return List.of();
    }

    @Override
    public List<Review> findByProductId(Integer productId) {
        return List.of();
    }
}
