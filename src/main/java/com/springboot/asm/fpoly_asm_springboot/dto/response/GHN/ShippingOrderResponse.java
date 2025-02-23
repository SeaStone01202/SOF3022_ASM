package com.springboot.asm.fpoly_asm_springboot.dto.response.GHN;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShippingOrderResponse {

    Integer total;                   // Tổng tiền (có thể là số nguyên)
    Integer service_fee;             // Phí dịch vụ (có thể có số lẻ)
    Integer insurance_fee;           // Phí bảo hiểm (có thể có số lẻ)
    Integer pick_station_fee;        // Phí lấy hàng tại bưu cục (có thể có số lẻ)
    Integer coupon_value;            // Giá trị giảm giá (có thể có số lẻ)
    Integer r2s_fee;                 // Phí giao lại (có thể có số lẻ)
}
