package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "order_detail")
@IdClass(OrderDetailKey.class)
public class OrderDetail {

    @Id
    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private ProductOrder order;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(nullable = false)
    private Integer quantity;

    @Column(nullable = false)
    private Float subtotal;
}
