package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.request.CartItemRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CartItemResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.CartItem;

import java.util.List;

public interface CartService {

    CartItemResponse addCartItem(CartItemRequest request);

    CartItemResponse updateCartItem(Integer cartId,CartItemRequest request);

    void deleteCartItem(Integer cartId);

    void deleteAllCartItemsByUserId(Integer userId);

    List<CartItemResponse> getCartItemsByUserId(Integer userId);

    List<CartItemResponse> getCartItems();

    int getTotalQuantity(Integer userId);

    double getTotalAmount(Integer userId);

    void saveCartOnLogout(List<CartItem> cartInLocalStorage);

    public void clearAfterPayment(String userEmail);

    CartItemResponse getCartItemById(Integer cartId);
}
