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
@Table(name = "customer", schema = "storedb", uniqueConstraints = {
        @UniqueConstraint(name = "email_UNIQUE", columnNames = {"email"})
})
public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String firstname;

    private String lastname;

    private String addressLine1;

    private String addressLine2;

    private String city;

    private String state;

    private String country;

    private String phone;

    private String zipcode;

    private String password;

    private Instant registerDate;

}