package com.springboot.asm.fpoly_asm_springboot.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CartItemRequest {

    String name;

    double price;

    @Builder.Default
    int quantity = 1;

    double amount;

    Integer userId;

    public double getAmount() {
        return this.quantity * this.price;
    }

}
