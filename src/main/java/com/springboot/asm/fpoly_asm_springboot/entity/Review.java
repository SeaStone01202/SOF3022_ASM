package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "review", schema = "storedb")
public class Review {
    @Id
    @Column(name = "review_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    @Column(name = "rating", nullable = false)
    private Integer rating;

    @Size(max = 128)
    @NotNull
    @Column(name = "headline", nullable = false, length = 128)
    private String headline;

    @Size(max = 500)
    @NotNull
    @Column(name = "comment", nullable = false, length = 500)
    private String comment;

    @NotNull
    @Column(name = "review_time", nullable = false)
    private LocalDate reviewTime;

}