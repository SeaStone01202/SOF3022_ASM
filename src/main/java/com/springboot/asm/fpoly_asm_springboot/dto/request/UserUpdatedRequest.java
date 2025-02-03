package com.springboot.asm.fpoly_asm_springboot.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserUpdatedRequest {
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate birthday;

}
