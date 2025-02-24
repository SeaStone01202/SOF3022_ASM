package com.springboot.asm.fpoly_asm_springboot.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Setter
@Getter
public class UserUpdatedRequest {

    private String fullName;

    private String phone;

    private boolean gender;

    private LocalDate birthday;

}
