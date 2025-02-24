package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.springboot.asm.fpoly_asm_springboot.dto.request.CartItemRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.CartItemResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.CartItem;
import com.springboot.asm.fpoly_asm_springboot.entity.Product;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.mapper.CartItemMapper;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.CartItemRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.ProductRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.UserRepository;
import com.springboot.asm.fpoly_asm_springboot.service.CartService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartService {

    CartItemMapper cartMapper;
    UserRepository userRepository;
    ProductRepository productRepository;
    CartItemRepository cartItemRepository;


    @Override
    public CartItemResponse addCartItem(CartItemRequest request) {

        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

        CartItem newItem = CartItem.builder().
                product(product).
                price(product.getPrice()).
                quantity(request.getQuantity())
                .amount(request.getQuantity() * product.getPrice())
                .user(userRepository.findById(request.getUserId())
                        .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)))
                .build();


        return cartMapper.toCartItemResponse(cartItemRepository.save(newItem));
    }


    @Override
    public CartItemResponse updateCartItem(Integer cartId, CartItemRequest request) {

        CartItem existingItem = cartItemRepository.findById(cartId)
                .orElseThrow(() -> new AppException(ErrorCode.CART_ITEM_NOT_FOUND));

        return cartMapper.toCartItemResponse(existingItem);
    }

    @Override
    public void deleteCartItem(Integer cartId) {
        var cart = cartItemRepository.findById(cartId)
                .orElseThrow(() -> new AppException(ErrorCode.CART_ITEM_NOT_FOUND));
        cartItemRepository.delete(cart);
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void deleteAllCartItemsByUserId(Integer userId) {
        try {
            cartItemRepository.deleteByUserId(userId);
        } catch (Exception e) {
            if (userRepository.existsById(userId)) throw new AppException(ErrorCode.USER_NOT_EXISTED);
        }
    }


    @Override
    public List<CartItemResponse> getCartItemsByUserId(Integer userId) {

        List<CartItemResponse> cartItemResponses = new ArrayList<>();

        var carts = cartItemRepository.findAll();

        for (CartItem cartItem : carts) {

            if (userId.equals(cartItem.getUser().getId())) {

                cartItemResponses.add(cartMapper.toCartItemResponse(cartItem));

            }
        }
        return cartItemResponses;
    }

    @Override
    public List<CartItemResponse> getCartItems() {
        return cartItemRepository.findAll()
                .stream()
                .map(cartMapper::toCartItemResponse)
                .toList();
    }


    @Override
    public int getTotalQuantity(Integer userId) {
        return cartItemRepository.findAll().stream()
                .filter(u -> u.getUser().getId().equals(userId))
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    @Override
    public double getTotalAmount(Integer userId) {
        return cartItemRepository.findAll().stream()
                .filter(u -> u.getUser().getId().equals(userId))
                .mapToDouble(item -> item.getPrice() * item.getQuantity()).
                sum();
    }

    @Override
    public void saveCartOnLogout(List<CartItem> cartInLocalStorage) {
        cartItemRepository.saveAll(cartInLocalStorage);
    }

    @Override
    public void clearAfterPayment(String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        cartItemRepository.deleteByUserId(user.getId());
    }

    @Override
    public CartItemResponse getCartItemById(Integer cartId) {
        return cartMapper.toCartItemResponse(cartItemRepository.findById(cartId)
                .orElseThrow(() -> new AppException(ErrorCode.CART_ITEM_NOT_FOUND)));
    }
}
