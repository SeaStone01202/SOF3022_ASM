package com.springboot.asm.fpoly_asm_springboot.services.impl;

import com.springboot.asm.fpoly_asm_springboot.entities.Customer;
import com.springboot.asm.fpoly_asm_springboot.entities.OrderDetail;
import com.springboot.asm.fpoly_asm_springboot.entities.Product;
import com.springboot.asm.fpoly_asm_springboot.entities.ProductOrder;
import com.springboot.asm.fpoly_asm_springboot.repositories.OrderDetailRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.ProductOrderRepository;
import com.springboot.asm.fpoly_asm_springboot.services.CartService;

import java.util.List;
import java.util.Optional;

public class CartServiceImpl implements CartService {

    ProductOrderRepository productOrderRepository;
    OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetail> getCartItems(ProductOrder order) {
        return orderDetailRepository.findAll();
    }

    @Override
    public ProductOrder retrieveLocalCart() {
        return null;
    }

    @Override
    public ProductOrder retrieveRemoteCart(Customer customer) {
         Optional<ProductOrder> order = productOrderRepository.findById(customer.getCustomerId());
         return order.orElse(null);
    }

    @Override
    public void addItem(Product newProd) {

    }

    @Override
    public void removeItem(Product removedProd) {

    }

    @Override
    public void modifyItem(OrderDetail modifiedProd) {

    }

    @Override
    public void removeAllItems() {

    }

    @Override
    public Double getTotalPrice() {
        return 0.0;
    }

    @Override
    public Double applyCoupon(String couponId) {
        return 0.0;
    }

    @Override
    public void saveCart() {

    }

    @Override
    public void saveToLocalCart() {

    }

    @Override
    public void saveToRemoteCart() {

    }
}
