package com.springboot.asm.fpoly_asm_springboot.mapper;


import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductOrderRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductOrderResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.ProductOrder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderProductMapper {
    ProductOrder toProductOrder(ProductOrderRequest request);

    @Mapping(target = "emailUser" , source = "user.email")
    ProductOrderResponse toProductOrderResponse(ProductOrder order);

}
