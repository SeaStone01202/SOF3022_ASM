package com.springboot.asm.fpoly_asm_springboot.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "product_order")
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Integer orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @Column(name = "order_date", nullable = false)
    private LocalDate orderDate;

    @Column(name = "r_address_line1", nullable = false)
    private String rAddressLine1;

    @Column(name = "r_address_line2")
    private String rAddressLine2;

    @Column(name = "r_firstname", nullable = false)
    private String rFirstname;

    private String rLastname;

    @Column(name = "r_phone", nullable = false)
    private String rPhone;

    private String rCountry;

    private String rCity;

    private String rState;

    private String rZipcode;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    private Float shippingFee;

    private Float tax;

    private Float subtotal;

    @Column(nullable = false)
    private Float total;

    @Column(nullable = false)
    private String status;
}
