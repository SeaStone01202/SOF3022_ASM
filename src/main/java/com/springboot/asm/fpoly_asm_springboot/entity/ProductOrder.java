package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Entity
@Table
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    private Date orderDate;

    @Size(max = 30)
    @NotNull
    private String rFirstname;

    @Size(max = 30)
    private String rLastname;

    @Size(max = 15)
    @NotNull
    private String rPhone;

    private Integer rCountry;

    private Integer rCity;

    private String rState;

    private String rWard;

    @Size(max = 20)
    @NotNull
    private String paymentMethod;

    private int service_id;

    private Float shippingFee;

    private Float subtotal;

    @NotNull
    private Double total;

    @NotNull
    private String status;

}