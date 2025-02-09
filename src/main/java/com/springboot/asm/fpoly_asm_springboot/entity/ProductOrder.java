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
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull
    private Date orderDate;

    @Size(max = 256)
    @NotNull
    private String rAddressLine1;

    @Size(max = 256)
    private String rAddressLine2;

    @Size(max = 30)
    @NotNull
    private String rFirstname;

    @Size(max = 30)
    private String rLastname;

    @Size(max = 15)
    @NotNull
    private String rPhone;

    @Size(max = 4)
    private String rCountry;

    @Size(max = 32)
    private String rCity;

    @Size(max = 45)
    private String rState;

    @Size(max = 20)
    @NotNull
    private String paymentMethod;

    private Float shippingFee;

    private Float subtotal;

    @NotNull
    private Double total;

    @NotNull
    private String status;

}