package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.DistrictRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.ShippingMethodRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.ShippingOrderRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.WardRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.GHN.*;
import com.springboot.asm.fpoly_asm_springboot.service.GHNService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shipping")
@RequiredArgsConstructor
public class GHNController {

    private final GHNService ghnService;

    @GetMapping("/provinces")
    public ApiResponse<List<ProvinceResponse>> getProvinces() {
        return ApiResponse.<List<ProvinceResponse>>builder()
                .result(ghnService.getProvinces())
                .build();
    }

    @PostMapping("/districts")
    public ApiResponse<List<DistrictResponse>> getDistricts(@RequestBody DistrictRequest request) {
        return ApiResponse.<List<DistrictResponse>>builder()
                .result(ghnService.getDistricts(request))
                .build();
    }


    @PostMapping("/wards")
    public ApiResponse<List<WardResponse>> getWards(@RequestBody WardRequest request) {
        return ApiResponse.<List<WardResponse>>builder()
                .result(ghnService.getWards(request))
                .build();
    }


    @PostMapping("/methods")
    public ApiResponse<List<ShippingMethodResponse>> getShippingMethods(@RequestBody ShippingMethodRequest request) {
        return ApiResponse.<List<ShippingMethodResponse>>builder()
                .result(ghnService.createShippingMethod(request))
                .build();
    }


    @PostMapping("/fee")
    public ApiResponse<ShippingOrderResponse> getShippingOrder(@RequestBody ShippingOrderRequest request) {
        return ApiResponse.<ShippingOrderResponse>builder()
                .result(ghnService.createShippingOrder(request))
                .build();
    }
}
