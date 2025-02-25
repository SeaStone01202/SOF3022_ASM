package com.springboot.asm.fpoly_asm_springboot.dto.response.GHN;

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
public class ShippingMethodResponse {

    int service_id;          // ID dịch vụ vận chuyển
    int service_type_id;     // Loại dịch vụ
    String short_name;       // Tên ngắn của dịch vụ
}
