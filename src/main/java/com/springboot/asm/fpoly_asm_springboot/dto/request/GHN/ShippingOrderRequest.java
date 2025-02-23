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
    Integer insuranceValue;         // Giá trị bảo hiểm hàng hóa (dùng BigDecimal để tránh mất dữ liệu)

    @JsonProperty("cod_failed_amount")
    Integer codFailedAmount;        // Số tiền phải thu khi giao hàng thất bại

    @JsonProperty("coupon")
    String coupon;                     // Mã giảm giá (nullable)

    @JsonProperty("from_district_id")
    @Builder.Default
    Integer fromDistrictId = 1454;            // ID quận/huyện gửi hàng

    @JsonProperty("from_ward_code")
    @Builder.Default
    String fromWardCode = "21211";               // Mã phường/xã gửi hàng (bị thiếu trong DTO cũ)

    @JsonProperty("to_district_id")
    Integer toDistrictId;              // ID quận/huyện nhận hàng

    @JsonProperty("to_ward_code")
    String toWardCode;                 // Mã phường/xã nhận hàng

    @JsonProperty("height")
    @Builder.Default
    Integer height = 5;                     // Chiều cao của gói hàng (cm)

    @JsonProperty("length")
    @Builder.Default
    Integer length = 30;                     // Chiều dài của gói hàng (cm)

    @JsonProperty("weight")
    @Builder.Default
    Integer weight = 200;                     // Trọng lượng gói hàng (gram)

    @JsonProperty("width")
    @Builder.Default
    Integer width = 40;                       // Chiều rộng của gói hàng (cm)
}
