package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ReviewRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CategoryResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ReviewResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Review;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.ReviewRepository;
import com.springboot.asm.fpoly_asm_springboot.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @PostMapping
    public ApiResponse<ReviewResponse> createReview(@RequestBody ReviewRequest request) {
        return ApiResponse.<ReviewResponse>builder().result(reviewService.create(request)).build();
    }

    @GetMapping()
    public Page<ReviewResponse> retrieveReviews(@RequestParam int page) {
        return reviewService.findAll(page);
    }

    @GetMapping("/{productId}")
    public Page<ReviewResponse> getReviewsByProductId(@RequestParam int page, @PathVariable Integer productId) {
        return reviewService.findByProductId(productId, page);
    }
}
