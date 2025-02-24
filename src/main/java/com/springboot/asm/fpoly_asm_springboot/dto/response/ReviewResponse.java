package com.springboot.asm.fpoly_asm_springboot.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewResponse {

    private Integer id;

    private String headline;

    private String comment;

    private Integer rating;

    private Integer userId;

    private Integer productId;

    private String username;
}
