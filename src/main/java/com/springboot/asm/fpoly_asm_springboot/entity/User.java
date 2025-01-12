package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Integer id;

    @Size(max = 64)
    @NotNull
    @Column(name = "email", nullable = false, length = 64)
    private String email;

    @Size(max = 32)
    @NotNull
    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @Size(max = 64)
    @NotNull
    @Column(name = "full_name", nullable = false, length = 64)
    private String fullName;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Size(max = 11)
    @Column(name = "phone", length = 11)
    private String phone;

    @Column(name = "gender")
    private Boolean gender;

    @Column(name = "role")
    private Boolean role;

}