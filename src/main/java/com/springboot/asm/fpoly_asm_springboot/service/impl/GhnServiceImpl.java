package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.asm.fpoly_asm_springboot.constant.GHN;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.DistrictRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.ShippingMethodRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.ShippingOrderRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.WardRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.GHN.*;
import com.springboot.asm.fpoly_asm_springboot.service.GHNService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GhnServiceImpl implements GHNService {

    private final WebClient webClient;

    @Override
    public ShippingOrderResponse createShippingOrder(ShippingOrderRequest request) {

        String jsonResponse = postWebClientOrderResponse(GHN.API_URL_SHIPPING_ORDER, request);

        JsonNode node = getNodeData(jsonResponse, "data");

        return ShippingOrderResponse.builder()
                .coupon_value((node.path("coupon_value").asInt()))
                .total((node.path("total").asInt()))
                .service_fee((node.path("service_fee").asInt()))
                .r2s_fee((node.path("r2s_fee").asInt()))
                .insurance_fee((node.path("insurance_fee").asInt()))
                .pick_station_fee((node.path("pick_station_fee").asInt()))
                .build();
    }

    @Override
    public List<ProvinceResponse> getProvinces() {

        String jsonResponse = getWebClientResponse(GHN.API_URL_PROVINCE);

        // Trích xuất danh sách province từ "data"
        JsonNode dataNode = getNodeData(jsonResponse, "data");

        return StreamSupport.stream(dataNode.spliterator(), false)
                .map(node -> ProvinceResponse.builder()
                        .province_id(node.path("ProvinceID").asInt())
                        .province_name(node.path("ProvinceName").asText())
                        .province_code(node.path("Code").asText())
                        .build())
                .collect(Collectors.toList());
    }


    @Override
    public List<WardResponse> getWards(WardRequest request) {

        String jsonResponse = postWebClientMethodResponse(GHN.API_URL_WARD, request);

        JsonNode dataNode = getNodeData(jsonResponse, "data");

        return StreamSupport.stream(dataNode.spliterator(), false)
                .map(node -> WardResponse.builder()
                        .district_id(node.path("DistrictID").asInt())
                        .ward_code(node.path("WardCode").asText())
                        .ward_name(node.path("WardName").asText())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<DistrictResponse> getDistricts(DistrictRequest districtRequest) {

        String jsonResponse = postWebClientMethodResponse(GHN.API_URL_DISTRICT, districtRequest);

        JsonNode dataNode = getNodeData(jsonResponse, "data");

        return StreamSupport.stream(dataNode.spliterator(), false)
                .map(node -> DistrictResponse.builder()
                        .district_id(node.path("DistrictID").asInt())
                        .district_name(node.path("DistrictName").asText())
                        .district_code(node.path("DistrictCode").asText())
                        .province_id(node.path("ProvinceID").asInt())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public List<ShippingMethodResponse> createShippingMethod(ShippingMethodRequest request) {

        String json = postWebClientMethodResponse(GHN.API_URL_SHIPPING_METHOD, request);

        JsonNode dataNode = getNodeData(json, "data");

        return StreamSupport.stream(dataNode.spliterator(), false)
                .map(node -> ShippingMethodResponse.builder()
                        .service_id(node.path("service_id").asInt())
                        .service_type_id(node.path("service_type_id").asInt())
                        .short_name(node.path("short_name").asText())
                        .build())
                .collect(Collectors.toList());
    }


    private String getWebClientResponse(String url) {
        return this.webClient.get()
                .uri(url)
                .header("token", GHN.TOKEN_API)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private <T> String postWebClientMethodResponse(String url, T request) {
        return this.webClient.post()
                .uri(url)
                .header("token", GHN.TOKEN_API)
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }


    private <T> String postWebClientOrderResponse(String url, T request) {
        return this.webClient.post()
                .uri(url)
                .header("token", GHN.TOKEN_API)
                .header("ShopID", String.valueOf(GHN.SHOP_ID))
                .bodyValue(request)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private JsonNode getNodeData(String jsonResponse, String nameNode) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readTree(jsonResponse).path(nameNode);
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch data from GHN", e);
        }
    }
}
