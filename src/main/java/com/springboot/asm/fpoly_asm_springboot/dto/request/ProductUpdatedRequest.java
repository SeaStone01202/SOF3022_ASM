package com.springboot.asm.fpoly_asm_springboot.dto.request;

import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductUpdatedRequest {

    private String name;

    private String description;

    private Integer quantity;

    private Float price;

    private Integer categoryId;
}
