package com.springboot.asm.fpoly_asm_springboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    private String description;

    private String image;

    @Column(nullable = false)
    private Float price;

    @Column(name = "publish_date", nullable = false)
    private LocalDate publishDate;

    @Column(name = "last_update_time", nullable = false)
    private LocalDate lastUpdateTime;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
}