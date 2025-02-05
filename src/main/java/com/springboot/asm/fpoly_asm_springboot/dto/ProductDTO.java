package com.springboot.asm.fpoly_asm_springboot.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    @NotNull(message = "ID sản phẩm không được để trống!")
    private Integer productId;

    @NotBlank(message = "Tên sản phẩm không được để trống!")
    @Size(max = 255, message = "Tên sản phẩm không được dài quá 255 ký tự!")
    private String name;

    @NotBlank(message = "Tác giả không được để trống!")
    @Size(max = 255, message = "Tên tác giả không được dài quá 255 ký tự!")
    private String author;

    @Size(max = 500, message = "Mô tả không được dài quá 500 ký tự!")
    private String description;

    @Size(max = 255, message = "Đường dẫn ảnh không được dài quá 255 ký tự!")
    private String image;

    @NotNull(message = "Giá không được để trống!")
    @DecimalMin(value = "0.0", inclusive = false, message = "Giá phải lớn hơn 0!")
    private Float price;

    @NotNull(message = "Ngày xuất bản không được để trống!")
    private LocalDate publishDate;

    @NotNull(message = "Thời gian cập nhật không được để trống!")
    private LocalDate lastUpdateTime;

    @NotNull(message = "Danh mục không được để trống!")
    private Integer categoryId;
}