package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "product")
public class    Product {
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private int quantity;

    private String size;

    private String description;

    private String image;

    private Float price;

    @Column(name = "publish_date", nullable = true)
    private Date publishDate;

    @Column(name = "last_update_time", nullable = true)
    private Date lastUpdateTime;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Product() {}
    public Product(String name, String s, String url, int i, int i1, String l, LocalDate of, LocalDateTime of1, Category category) {
        this.name = name;
        this.quantity = i;
        this.size = l;
        this.description = s;
        this.image = url;
        this.price = Float.valueOf(i);
        this.publishDate = Date.valueOf(of);
        this.category = category;
    }
}