package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private Integer reviewId;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private String headline;

    @Column(nullable = false)
    private String comment;

    @Column(name = "review_time", nullable = false)
    private LocalDateTime reviewTime;
}