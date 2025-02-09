package com.springboot.asm.fpoly_asm_springboot.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemResponse {

    Integer id;

    String name;

    double price;

    @Builder.Default
    int quantity = 1;


    double amount;

    String emailUser;
    
    public double getAmount() {
        return this.quantity * this.price;
    }

}
