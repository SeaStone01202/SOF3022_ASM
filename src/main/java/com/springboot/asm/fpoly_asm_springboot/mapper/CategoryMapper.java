package com.springboot.asm.fpoly_asm_springboot.mapper;


import com.springboot.asm.fpoly_asm_springboot.dto.request.CategoryRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CategoryResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toCategory(CategoryRequest request);

    CategoryResponse toCategoryResponse(Category category);

    void updateCategory(@MappingTarget Category category, CategoryRequest request);
}
