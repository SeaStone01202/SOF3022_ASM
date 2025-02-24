package com.springboot.asm.fpoly_asm_springboot.dto.request;

import com.springboot.asm.fpoly_asm_springboot.entity.Category;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCreationRequest {

    private String name;

    private String description;

    private String size;

    private Integer quantity;

    private Float price;

    private Integer categoryId;
}
