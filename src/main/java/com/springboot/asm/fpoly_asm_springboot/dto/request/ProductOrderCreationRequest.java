package com.springboot.asm.fpoly_asm_springboot.dto.request;

import com.springboot.asm.fpoly_asm_springboot.entity.Customer;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductOrderCreationRequest {

    private Customer customer;

    private Instant orderDate;

    private String rAddressLine1;

    private String rAddressLine2;

    private String rFirstname;

    private String rLastname;

    private String rPhone;

    private String rCountry;

    private String rCity;

    private String rState;

    private String rZipcode;

    private String paymentMethod;

    private Float shippingFee;

    private Float tax;

    private Float subtotal;

    private Float total;

    private String status;

}