package com.springboot.asm.fpoly_asm_springboot.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @Email(message = "Email không đúng định dạng!")
    @NotNull(message = "Email không được để trống!")
    @Size(max = 64, message = "Email không được vượt quá 64 ký tự")
    private String email;

    @NotNull(message = "Mật khẩu không được để trống!")
    @Size(max = 32, message = "Mật khẩu không được vượt quá 32 ký tự")
    private String password;

    @NotBlank(message = "Tên đầy đủ không được để trống!")
    @Size(max = 64, message = "Tên không được dài quá 64 ký tự")
    private String fullName;

    @Past(message = "Ngày sinh phải bé hơn hôm nay!")
    private LocalDate birthday;

    @Size(max = 10, message = "Số điện thoại phải là 10 số!")
    private String phone;

    @NotNull(message = "Giới tính không được để trống!")
    private Boolean gender;

    @NotNull(message = "Vai trò không được để trống!")
    private Boolean role;
}
