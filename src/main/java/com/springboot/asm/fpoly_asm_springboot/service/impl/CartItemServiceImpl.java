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
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CartItemServiceImpl implements CartService {

    Map<Integer, CartItem> cartCached = new ConcurrentHashMap<>();
    CartItemMapper cartMapper;
    UserRepository userRepository;
    ProductRepository productRepository;
    CartItemRepository cartItemRepository;


    @Override
    public CartItemResponse addCartItem(CartItemRequest request) {

        int key = request.getProductId();

        if (cartCached.containsKey(key)) {
            return updateCartItem(request);

        } else {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_EXISTED));

            CartItem newItem = CartItem.builder().
                    product(product).
                    price(product.getPrice()).
                    quantity(request.getQuantity()).
                    amount(getAmount(product.getPrice(), request.getQuantity()))
                    .user(userRepository.findById(request.getUserId())
                            .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED)))
                    .build();

            cartCached.put(key, newItem);

            log.info("New cart created {} in cache", newItem);

            return cartMapper.toCartItemResponse(newItem);
        }
    }

    @Override
    public CartItemResponse updateCartItem(CartItemRequest request) {

        int key = request.getProductId();

        if (!cartCached.containsKey(key)) {
            throw new AppException(ErrorCode.CART_ITEM_NOT_FOUND);
        }

        CartItem existingItem = cartCached.get(key);

        existingItem.setQuantity(existingItem.getQuantity() + request.getQuantity());

        cartCached.put(key, existingItem);

        log.info("Cart updated {} in cache", existingItem);

        return cartMapper.toCartItemResponse(existingItem);
    }

    @Override
    public void deleteCartItem(CartItemRequest request) {
        int key = request.getUserId();
        if (!cartCached.containsKey(key)) {
            throw new AppException(ErrorCode.CART_ITEM_NOT_FOUND);
        }
        cartCached.remove(key);
        log.debug("Cart deleted {} in cache", key);
    }

    @Override
    public void clear() {

        cartCached.clear();
        log.debug("All Item in cart cleared");
    }

    @Override
    public List<CartItemResponse> getCartItems(Integer userId) {

        List<CartItemResponse> cartItemResponses = new ArrayList<>();


        if (cartCached.isEmpty()) {
            var carts = cartItemRepository.findAll();

            for (CartItem cartItem : carts) {
                if (cartItem.getUser().getId().equals(userId)) {
                    cartItemResponses.add(cartMapper.toCartItemResponse(cartItem));
                }
            }

            return cartItemResponses;
        }

        var cartItems = cartCached.values().stream().toList();


        for (CartItem cartItem : cartItems) {

            cartItemResponses.add(cartMapper.toCartItemResponse(cartItem));

        }

        return cartItemResponses;
    }

    @Override
    public int getTotalQuantity(Integer userId) {
        return cartCached.values().stream()
                .filter(u -> u.getUser().getId().equals(userId))
                .mapToInt(CartItem::getQuantity)
                .sum();
    }

    @Override
    public double getTotalAmount(Integer userId) {
        return cartCached.values().stream()
                .filter(u -> u.getUser().getId().equals(userId))
                .mapToDouble(item -> item.getPrice() * item.getQuantity()).
                sum();
    }

    @Override
    public void saveCartOnLogout(String email) {
        if (cartCached.isEmpty()) {
            log.debug("No cart to save");
            return;
        }
        List<CartItem> cartItems = cartCached.values().
                stream().
                filter(cartItem -> cartItem.getUser().getEmail().equals(email)).
                toList();

        cartItemRepository.saveAll(cartItems);

        log.debug("Cart saved {} in cache", cartItems);

        clear();
    }

    @Override
    public void clearAfterPayment(String userEmail) {
        User user = userRepository.findByEmail(userEmail).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));

        cartItemRepository.deleteByUserId(user.getId());

        log.info("Cart deleted by user {} in database ", user.getEmail());

        cartCached.remove(userEmail);
    }

    private Float getAmount(Float price, Integer quantity) {
        return price * quantity;
    }
}
