package com.springboot.asm.fpoly_asm_springboot.dto.request.GHN;

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
public class ShippingOrderRequest {

    Integer service_id;                 // ID của dịch vụ GHN
    BigDecimal insurance_value;         // Giá trị bảo hiểm hàng hóa
    String coupon;                      // Mã giảm giá (nullable)
    Integer from_district_id;           // ID quận/huyện gửi hàng
    Integer to_district_id;             // ID quận/huyện nhận hàng
    String to_ward_code;                // Mã phường/xã nhận hàng
    Integer height;                      // Chiều cao của gói hàng (cm)
    Integer length;                      // Chiều dài của gói hàng (cm)
    Integer weight;                      // Trọng lượng gói hàng (gram)
    Integer width;                       // Chiều rộng của gói hàng (cm)
}
