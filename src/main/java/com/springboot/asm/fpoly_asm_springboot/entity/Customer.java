package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false)
    private Integer id;

    @Size(max = 64)
    @NotNull
    @Column(name = "email", nullable = false, length = 64)
    private String email;

    @Size(max = 30)
    @NotNull
    @Column(name = "firstname", nullable = false, length = 30)
    private String firstname;

    @Size(max = 30)
    @NotNull
    @Column(name = "lastname", nullable = false, length = 30)
    private String lastname;

    @Size(max = 128)
    @NotNull
    @Column(name = "address_line1", nullable = false, length = 128)
    private String addressLine1;

    @Size(max = 128)
    @Column(name = "address_line2", length = 128)
    private String addressLine2;

    @Size(max = 32)
    @NotNull
    @Column(name = "city", nullable = false, length = 32)
    private String city;

    @Size(max = 45)
    @NotNull
    @Column(name = "state", nullable = false, length = 45)
    private String state;

    @Size(max = 4)
    @NotNull
    @Column(name = "country", nullable = false, length = 4)
    private String country;

    @Size(max = 15)
    @NotNull
    @Column(name = "phone", nullable = false, length = 15)
    private String phone;

    @Size(max = 24)
    @NotNull
    @Column(name = "zipcode", nullable = false, length = 24)
    private String zipcode;

    @Size(max = 16)
    @NotNull
    @Column(name = "password", nullable = false, length = 16)
    private String password;

    @NotNull
    @Column(name = "register_date", nullable = false)
    private Instant registerDate;

    @OneToMany(mappedBy = "customer")
    private Set<ProductOrder> bookOrders = new LinkedHashSet<>();

    @OneToMany(mappedBy = "customer")
    private Set<Review> reviews = new LinkedHashSet<>();

}