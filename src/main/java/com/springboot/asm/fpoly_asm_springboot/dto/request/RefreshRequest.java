package com.springboot.asm.fpoly_asm_springboot.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RefreshRequest {

    private String token;
}
