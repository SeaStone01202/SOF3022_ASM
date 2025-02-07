package com.springboot.asm.fpoly_asm_springboot.dto.request;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerCreationRequest {

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

    private Date registerDate;

}