package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.request.CartItemRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CartItemResponse;

import java.util.List;

public interface CartService {

    CartItemResponse addCartItem(CartItemRequest request);

    CartItemResponse updateCartItem(CartItemRequest request);

    void deleteCartItem(CartItemRequest request);

    void clear();

    List<CartItemResponse> getCartItems(String email);

    int getTotalQuantity();

    double getTotalAmount();

    void saveCartOnLogout(String email);

    public void clearAfterPayment(String userEmail);
}
