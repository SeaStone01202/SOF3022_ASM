package com.poly.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class UserCreationRequest {
    @Size(min = 3, max = 50, message = "USERNAME_INVALID")
    private String username;

    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;
    @NotBlank
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

}
