package com.springboot.asm.fpoly_asm_springboot.mapper;

import com.springboot.asm.fpoly_asm_springboot.dto.request.CartItemRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CartItemResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.CartItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CartItemMapper {

    CartItem toCartItem(CartItemRequest request);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "productId" ,source = "product.id")
    CartItemResponse toCartItemResponse(CartItem cartItem);

    @Mapping(target = "user", ignore = true)
    void updateCartItem(@MappingTarget CartItem cartItem, CartItemRequest request);
}
