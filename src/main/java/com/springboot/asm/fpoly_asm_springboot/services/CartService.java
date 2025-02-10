package com.springboot.asm.fpoly_asm_springboot.services;

import com.springboot.asm.fpoly_asm_springboot.entities.Customer;
import com.springboot.asm.fpoly_asm_springboot.entities.OrderDetail;
import com.springboot.asm.fpoly_asm_springboot.entities.Product;
import com.springboot.asm.fpoly_asm_springboot.entities.ProductOrder;

import java.util.List;

/**
 * **/
public interface CartService {
    List<OrderDetail> getCartItems(ProductOrder order);
    ProductOrder retrieveLocalCart();
    ProductOrder retrieveRemoteCart(Customer customer);

    void addItem(Product newProd);
    void removeItem(Product removedProd);
    /**Change amount or design, etc. of the product in cart**/
    void modifyItem(OrderDetail modifiedProd);
    void removeAllItems();
    Double getTotalPrice();
    Double applyCoupon(String couponId);
    /**
     * Save cart state to client local storage or sth when logout without paying
     * **/
    void saveCart();
    void saveToLocalCart();
    void saveToRemoteCart();
}
