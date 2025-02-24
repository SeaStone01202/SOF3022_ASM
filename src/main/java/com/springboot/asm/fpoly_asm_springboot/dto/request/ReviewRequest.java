package com.springboot.asm.fpoly_asm_springboot.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReviewRequest {

    private Integer productId;

    private String headline;

    private Integer userId;

    private String comment;

    private Integer rating;

}
