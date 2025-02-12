package com.springboot.asm.fpoly_asm_springboot.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class ProductOrderResponse {

    private Integer id;

    private String emailUser;

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

    private Float subtotal;

    private Double total;

    private String status;
}
