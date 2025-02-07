package com.springboot.asm.fpoly_asm_springboot.dto.request;

import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductUpdatedRequest {

    private String name;

    private String author;

    private String description;

    private String image;

    private Float price;

    private String categoryName;
}
