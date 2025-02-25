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
public class DistrictResponse {

    Integer province_id;
    Integer district_id;
    String district_name;
    String district_code;
}
