package com.springboot.asm.fpoly_asm_springboot.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Setter
@Getter
public class UserUpdatedRequest {

    private String password;

    private String firstName;

    private String lastName;

    private String fullName = getLastName() + " " + getFirstName();

    private String phone;

    private LocalDate birthday;

}
