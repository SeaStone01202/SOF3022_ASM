package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

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

}