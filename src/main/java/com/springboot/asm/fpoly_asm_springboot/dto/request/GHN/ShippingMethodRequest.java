package com.springboot.asm.fpoly_asm_springboot.dto.request.GHN;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.springboot.asm.fpoly_asm_springboot.constant.GHN;
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

    @Builder.Default
    Integer shop_id = GHN.SHOP_ID;
    @Builder.Default// ID của shop
    Integer from_district = 1461;   // ID quận/huyện người gửi
    Integer to_district;     // ID quận/huyện người nhận
}
