package com.springboot.asm.fpoly_asm_springboot.dto.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LogoutRequest {

    private String token;
}
