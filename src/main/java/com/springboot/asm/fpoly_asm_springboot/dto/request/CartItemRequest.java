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

    @Builder.Default
    int quantity = 1;
    Integer id;
    Integer productId;
    Integer amount;
    Integer userId;

}
