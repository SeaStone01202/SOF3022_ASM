package com.springboot.asm.fpoly_asm_springboot.mapper;

import com.springboot.asm.fpoly_asm_springboot.dto.request.CategoryRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ReviewRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CategoryResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ReviewResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import com.springboot.asm.fpoly_asm_springboot.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    Review toReview(ReviewRequest request);

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "product.id", target = "productId")
    ReviewResponse toReviewResponse(Review review);

    void updateReview(@MappingTarget Review review, ReviewRequest request);

}
