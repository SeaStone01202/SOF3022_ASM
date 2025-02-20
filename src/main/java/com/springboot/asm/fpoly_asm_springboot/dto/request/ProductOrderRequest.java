package com.springboot.asm.fpoly_asm_springboot.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.asm.fpoly_asm_springboot.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ProductOrderRequest {

    private Integer userId;

    private Date orderDate;

    private String rAddressLine1;

    private String rAddressLine2;

    private String rFirstname;

    private String rLastname;

    private String rPhone;

    private String rCountry;

    private String rCity;

    private String rState;

    private String paymentMethod;

    private Float shippingFee;

    private Double subtotal;

    private Double total;

}
