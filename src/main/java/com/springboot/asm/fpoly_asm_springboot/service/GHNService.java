package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.DistrictRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.ShippingMethodRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.ShippingOrderRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.WardRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.GHN.*;

import java.util.List;

public interface GHNService {

    ShippingOrderResponse createShippingOrder(ShippingOrderRequest request);
    List<ProvinceResponse>  getProvinces();
    List<WardResponse> getWards(WardRequest request);
    List<DistrictResponse> getDistricts(DistrictRequest districtRequest);
    List<ShippingMethodResponse> createShippingMethod(ShippingMethodRequest request);
}
