package com.springboot.asm.fpoly_asm_springboot.service.impl;


import com.springboot.asm.fpoly_asm_springboot.dto.request.ReviewRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ReviewResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import com.springboot.asm.fpoly_asm_springboot.entity.Review;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import com.springboot.asm.fpoly_asm_springboot.mapper.ReviewMapper;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.ProductRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.ReviewRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.UserRepository;
import com.springboot.asm.fpoly_asm_springboot.service.ReviewService;
import com.springboot.asm.fpoly_asm_springboot.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewMapper reviewMapper;

    private final ProductRepository productRepository;

    private final UserRepository userRepository;

    private final PageUtil pageUtil;

    @Override
    public ReviewResponse create(ReviewRequest request) {
        Optional<Product> product = productRepository.findById(request.getProductId());

        Optional<User> user = userRepository.findById(request.getUserId());

        Review review = new Review();
        BeanUtils.copyProperties(request, review);
        review.setProduct(product.get());
        review.setUser(user.get());
        review.setReviewTime(LocalDate.now());
        review.setRating(request.getRating());
        Review savedReview = reviewRepository.save(review);

        ReviewResponse reviewResponse = new ReviewResponse();
        BeanUtils.copyProperties(savedReview, reviewResponse);
        reviewResponse.setUsername(user.get().getFullName());

        return reviewResponse;
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
    public Page<ReviewResponse> findAll(int page) {
        Pageable pageable = pageUtil.createPageable(page);
        return reviewRepository.findAll(pageable).map(reviewMapper::toReviewResponse);
    }

    @Override
    public Optional<Review> findById(Integer id) {
        return reviewRepository.findById(id);
    }

    @Override
    public Page<Review> findByUserId(Integer userId, int page) {
        return reviewRepository.findAllByUserId(userId, pageUtil.createPageable(page));
    }

    @Override
    public Page<ReviewResponse> findByProductId(Integer productId, int page) {
        Pageable pageable = pageUtil.createPageable(page,2);
        var reviews = reviewRepository.findAllByProductId(pageable, productId);
        return reviews.map(reviewMapper::toReviewResponse);
    }

}
