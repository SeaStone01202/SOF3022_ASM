package com.springboot.asm.fpoly_asm_springboot.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    @NotEmpty
    @Email
    private String email;

    @Size(min = 6, max = 20, message = "Minimum password length is 6 characters")
    private String password;

    private String confirmPassword;

    private String phone;
}
