package com.springboot.asm.fpoly_asm_springboot.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    @Email(message = "Email không hợp lệ!")
    @Size(max = 64, message = "Email không được vượt quá 64 ký tự!")
    @NotNull(message = "Email không được để trống!")
    private String email;

    @NotBlank(message = "Tên không được để trống!")
    private String firstname;

    @NotBlank(message = "Họ không được để trống!")
    private String lastname;

    @NotBlank(message = "Địa chỉ dòng 1 không được để trống!")
    private String addressLine1;

    private String addressLine2;

    @NotBlank(message = "Thành phố không được để trống!")
    private String city;

    @NotBlank(message = "Bang không được để trống!")
    private String state;

    @NotBlank(message = "Quốc gia không được để trống!")
    private String country;

    @NotBlank(message = "Số điện thoại không được để trống!")
    @Size(min = 10, max = 15, message = "Số điện thoại phải có độ dài từ 10 đến 15 ký tự!")
    private String phone;

    @NotBlank(message = "Mã bưu điện không được để trống!")
    @Size(min = 5, max = 10, message = "Mã bưu điện phải có độ dài từ 5 đến 10 ký tự!")
    private String zipcode;

    @NotBlank(message = "Mật khẩu không được để trống!")
    @Size(min = 6, max = 32, message = "Mật khẩu phải có độ dài từ 6 đến 32 ký tự!")
    private String password;

    private LocalDate registerDate;
}
