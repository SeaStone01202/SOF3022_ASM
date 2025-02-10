package com.springboot.asm.fpoly_asm_springboot.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserResponse {
    Integer id;

    String email;

    String fullName;

    String firstName;

    String lastName;

    String phone;

    String gender;

    LocalDate birthday;

    Boolean role;

    String avatar;
}
