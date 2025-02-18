package com.springboot.asm.fpoly_asm_springboot.dto.request.GHN;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("service_id")
    Integer serviceId;                 // ID của dịch vụ GHN

    @JsonProperty("insurance_value")
    BigDecimal insuranceValue;         // Giá trị bảo hiểm hàng hóa (dùng BigDecimal để tránh mất dữ liệu)

    @JsonProperty("cod_failed_amount")
    BigDecimal codFailedAmount;        // Số tiền phải thu khi giao hàng thất bại

    @JsonProperty("coupon")
    String coupon;                     // Mã giảm giá (nullable)

    @JsonProperty("from_district_id")
    Integer fromDistrictId;            // ID quận/huyện gửi hàng

    @JsonProperty("from_ward_code")
    String fromWardCode;               // Mã phường/xã gửi hàng (bị thiếu trong DTO cũ)

    @JsonProperty("to_district_id")
    Integer toDistrictId;              // ID quận/huyện nhận hàng

    @JsonProperty("to_ward_code")
    String toWardCode;                 // Mã phường/xã nhận hàng

    @JsonProperty("height")
    Integer height;                     // Chiều cao của gói hàng (cm)

    @JsonProperty("length")
    Integer length;                     // Chiều dài của gói hàng (cm)

    @JsonProperty("weight")
    Integer weight;                     // Trọng lượng gói hàng (gram)

    @JsonProperty("width")
    Integer width;                       // Chiều rộng của gói hàng (cm)
}
