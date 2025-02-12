package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.DistrictRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.ShippingOrderRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.WardRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.GHN.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface GHNService {

    ShippingOrderResponse createShippingOrder(ShippingOrderRequest request);
    List<ProvinceResponse>  getProvinces();
    WardResponse getWard(WardRequest request);
    DistrictResponse getDistrict(DistrictRequest districtRequest);

    List<DistrictResponse> getDistricts();

}
