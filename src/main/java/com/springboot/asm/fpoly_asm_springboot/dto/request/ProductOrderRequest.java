package com.springboot.asm.fpoly_asm_springboot.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
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

    private String rFirstname;

    private String rLastname;

    private String rPhone;

    private Integer rCity;

    private Integer rState;

    private String rWard;

    private String paymentMethod;

    private int service_id;

    private Float shippingFee;

    private Double subtotal;

    private Double total;

}
