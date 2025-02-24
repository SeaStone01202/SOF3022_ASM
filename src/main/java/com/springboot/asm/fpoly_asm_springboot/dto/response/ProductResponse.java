package com.springboot.asm.fpoly_asm_springboot.dto.response;

import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ProductResponse {

    private int id;

    private String name;

    private String description;

    private String image;

    private Float price;

    private String size;

    private int quantity;

    private Date publishDate;

    private Date lastUpdateTime;

    private Integer categoryId;
}
