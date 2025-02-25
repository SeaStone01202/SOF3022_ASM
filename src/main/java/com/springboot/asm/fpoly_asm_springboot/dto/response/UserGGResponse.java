package com.springboot.asm.fpoly_asm_springboot.dto.response;

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
public class UserGGResponse {
    Integer id;

    String email;

    String fullName;

    String firstName;

    String lastName;

    String phone;

    Boolean role;

    String avatar;

    String token;
}
