package com.springboot.asm.fpoly_asm_springboot.dto.request.GHN;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingMethodRequest {

    Integer shop_id;         // ID của shop
    Integer from_district;   // ID quận/huyện người gửi
    Integer to_district;     // ID quận/huyện người nhận
}
