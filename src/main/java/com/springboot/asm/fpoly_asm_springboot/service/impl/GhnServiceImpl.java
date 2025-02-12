package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.asm.fpoly_asm_springboot.constant.GHN;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.DistrictRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.ShippingOrderRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.request.GHN.WardRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.GHN.*;
import com.springboot.asm.fpoly_asm_springboot.service.GHNService;
import com.springboot.asm.fpoly_asm_springboot.util.RestIO;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class GhnServiceImpl implements GHNService {

    private final WebClient webClient;

    @Override
    public ShippingOrderResponse createShippingOrder(ShippingOrderRequest request) {
        return null;
    }

    @Override
    public List<ProvinceResponse> getProvinces() {
        try {
            String jsonResponse = webClient.get()
                    .uri(GHN.API_URL_PROVINCE)
                    .header("token", GHN.TOKEN_API)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // Chuyển đổi JSON sang danh sách ProvinceResponse
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            // Trích xuất danh sách province từ "result.data"
            JsonNode dataNode = rootNode.path("data");

            return StreamSupport.stream(dataNode.spliterator(), false)
                    .map(node -> ProvinceResponse.builder()
                            .province_id(node.path("ProvinceID").asInt())
                            .province_name(node.path("ProvinceName").asText())
                            .province_code(node.path("Code").asText())
                            .build())
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch province data from GHN", e);
        }
    }






    @Override
    public WardResponse getWard(WardRequest request) {
        return null;
    }

    @Override
    public DistrictResponse getDistrict(DistrictRequest districtRequest) {

        return null;
    }

    @Override
    public List<DistrictResponse> getDistricts() {
        return List.of();
    }
}
