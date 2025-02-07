package com.springboot.asm.fpoly_asm_springboot.controller;

/**
 * **/
public interface CartInterface<Cart, CartProdType> {
    String getCartItems();
    Cart retrieveLocalCart();
    Cart retrieveRemoteCart();

    String addItem(CartProdType newProd);
    String removeItem(CartProdType removedProd);
    /**Change amount or design, etc. of the product in cart**/
    String modifyItem(CartProdType modifiedProd);
    String removeAllItems();
    String getTotalPrice();
    String applyCoupon(String couponId);
    /**
     * Save cart state to client local storage or sth when logout without paying
     * **/
    String saveCart();
    String saveToLocalCart();
    String saveToRemoteCart();
}
