package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.CartItemRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CartItemResponse;
import com.springboot.asm.fpoly_asm_springboot.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {

    CartService cartService;

    @GetMapping("/items/{userId}")
    public ApiResponse<List<CartItemResponse>> getCart(@PathVariable Integer userId) {
        return ApiResponse.<List<CartItemResponse>>builder().
                result(cartService.getCartItemsByUserId(userId)).
                build();
    }

    @GetMapping()
    public ApiResponse<List<CartItemResponse>> getCart() {
        return null;
    }

    @PostMapping
    public ApiResponse<CartItemResponse> addCartItem(@RequestBody CartItemRequest cartItemRequest) {
        return ApiResponse.<CartItemResponse>builder().
                result(cartService.addCartItem(cartItemRequest)).
                build();
    }

    @PutMapping("/items/{cartId}")
    public ApiResponse<CartItemResponse> updateCartItem(
            @PathVariable Integer cartId
            , @RequestBody CartItemRequest cartItemRequest) {
        return ApiResponse.<CartItemResponse>builder().
                result(cartService.updateCartItem(cartId, cartItemRequest)).
                build();
    }

    @DeleteMapping("/items")
    public ApiResponse<?> deleteCartItem(@RequestBody CartItemRequest cartItemRequest) {
        return ApiResponse.<String>builder().
                result("Cart has been deleted in cached").
                build();
    }

    @GetMapping("/total-quantity/{userId}")
    public Integer getTotalQuantity(@PathVariable Integer userId) {
        return cartService.getTotalQuantity(userId);
    }

    @GetMapping("/total-amount/{userId}")
    public Double getTotalAmount(@PathVariable Integer userId) {
        return cartService.getTotalAmount(userId);
    }
}
