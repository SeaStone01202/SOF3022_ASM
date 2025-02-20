package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.BatchCartItemRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.CartItemRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CartItemResponse;
import com.springboot.asm.fpoly_asm_springboot.service.CartService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.util.List;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class CartController {

    CartService cartService;

    @GetMapping("/items/{userId}")
    public ApiResponse<List<CartItemResponse>> getCartByUserId(@PathVariable Integer userId) {
        return ApiResponse.<List<CartItemResponse>>builder().
                result(cartService.getCartItemsByUserId(userId)).
                build();
    }

    @GetMapping()
    public ApiResponse<List<CartItemResponse>> getCarts() {
        return ApiResponse.<List<CartItemResponse>>builder()
                .result(cartService.getCartItems())
                .build();
    }

    @GetMapping("/{cartItemId}")
    public ApiResponse<CartItemResponse> getCartItemById(@PathVariable Integer cartItemId) {
        return ApiResponse.<CartItemResponse>builder()
                .result(cartService.getCartItemById(cartItemId))
                .build();
    }

    @GetMapping("/total-quantity/{userId}")
    public Integer getTotalQuantity(@PathVariable Integer userId) {
        return cartService.getTotalQuantity(userId);
    }

    @GetMapping("/total-amount/{userId}")
    public Double getTotalAmount(@PathVariable Integer userId) {
        return cartService.getTotalAmount(userId);
    }

    @PostMapping
    public ApiResponse<CartItemResponse> addCartItem(@RequestBody CartItemRequest cartItemRequest) {
        return ApiResponse.<CartItemResponse>builder().
                result(cartService.addCartItem(cartItemRequest)).
                build();
    }

    @PutMapping("/{cartId}")
    public ApiResponse<CartItemResponse> updateCartItem(
            @PathVariable Integer cartId
            , @RequestBody CartItemRequest cartItemRequest) {
        return ApiResponse.<CartItemResponse>builder().
                result(cartService.updateCartItem(cartId, cartItemRequest)).
                build();
    }


    @PutMapping("/update-carts")
    public ApiResponse<List<CartItemResponse>> updateCartItems(
            @RequestBody BatchCartItemRequest batchCartItemRequest) {
        List<CartItemResponse> responses = batchCartItemRequest.getItems().stream()
                .map(item -> cartService.updateCartItem(item.getId(), item))
                .collect(Collectors.toList());
        return ApiResponse.<List<CartItemResponse>>builder()
                .result(responses)
                .build();
    }

    @DeleteMapping("/{cartId}")
    public ApiResponse<?> deleteCartItem(@PathVariable Integer cartId) {
        cartService.deleteCartItem(cartId);
        return ApiResponse.<String>builder().
                result("Cart has been deleted in cached").
                build();
    }

    @DeleteMapping("/items/{userId}")
    public ApiResponse<?> deleteCartItemsByUserId(@PathVariable Integer userId) {
        cartService.deleteAllCartItemsByUserId(userId);
        return ApiResponse.builder()
                .result("Delete cart item by user id successfully")
                .build();
    }

}