package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.GHN.ListProvincesResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.GHN.ProvinceResponse;
import com.springboot.asm.fpoly_asm_springboot.service.GHNService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/shipping")
@RequiredArgsConstructor
public class GHNController {

    private final GHNService ghnService;

    @GetMapping("/provinces")
    public ApiResponse<List<ProvinceResponse>> getProvinces() throws IOException {
        return ApiResponse.<List<ProvinceResponse>>builder().result(ghnService.getProvinces()).build();
    }
}
