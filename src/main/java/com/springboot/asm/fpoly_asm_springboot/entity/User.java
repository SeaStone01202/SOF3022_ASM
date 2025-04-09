package com.springboot.asm.fpoly_asm_springboot.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;

    private String password;

    private String fullName;

    private String avatar;

    private LocalDate birthday;

    private String phone;

    private Boolean gender;

    private Boolean role;

    public User(int id, String image, LocalDate of, String mail, String nguyễnBìnhMinh, int i, String number, String s, int i1) {
    }
}