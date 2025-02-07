package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "product_order", schema = "storedb", indexes = {
        @Index(name = "customer_fk_2_idx", columnList = "customer_id")
})
public class ProductOrder {
    @Id
    @Column(name = "order_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @NotNull
    @Column(name = "order_date", nullable = false)
    private Instant orderDate;

    @Size(max = 256)
    @NotNull
    @Column(name = "r_address_line1", nullable = false, length = 256)
    private String rAddressLine1;

    @Size(max = 256)
    @Column(name = "r_address_line2", length = 256)
    private String rAddressLine2;

    @Size(max = 30)
    @NotNull
    @Column(name = "r_firstname", nullable = false, length = 30)
    private String rFirstname;

    @Size(max = 30)
    @Column(name = "r_lastname", length = 30)
    private String rLastname;

    @Size(max = 15)
    @NotNull
    @Column(name = "r_phone", nullable = false, length = 15)
    private String rPhone;

    @Size(max = 4)
    @Column(name = "r_country", length = 4)
    private String rCountry;

    @Size(max = 32)
    @Column(name = "r_city", length = 32)
    private String rCity;

    @Size(max = 45)
    @Column(name = "r_state", length = 45)
    private String rState;

    @Size(max = 24)
    @Column(name = "r_zipcode", length = 24)
    private String rZipcode;

    @Size(max = 20)
    @NotNull
    @Column(name = "payment_method", nullable = false, length = 20)
    private String paymentMethod;

    @Column(name = "shipping_fee")
    private Float shippingFee;

    @Column(name = "tax")
    private Float tax;

    @Column(name = "subtotal")
    private Float subtotal;

    @NotNull
    @Column(name = "total", nullable = false)
    private Float total;

    @Size(max = 20)
    @NotNull
    @Column(name = "status", nullable = false, length = 20)
    private String status;

}