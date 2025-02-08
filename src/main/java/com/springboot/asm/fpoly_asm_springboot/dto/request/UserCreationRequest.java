package com.springboot.asm.fpoly_asm_springboot.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserCreationRequest {
    @Size(min = 3, message = "USERNAME_INVALID")
    private String email;

    @Size(min = 8, message = "PASSWORD_INVALID")
    private String password;
    @NotBlank(message = "FIELD_BLANK")
    private String firstName;

    private String lastName;

    private String fullName = lastName + " " + firstName;

    private LocalDate birthday;

    private String phone;

    private Boolean gender;

}
