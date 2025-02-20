package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.response.PaymentResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductOrderResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface PaymentService {

    PaymentResponse.VNPayResponse createVnPayPayment(HttpServletRequest request);

    ProductOrderResponse paymentCallBack(String vnp_ResponseCode, String vnp_TxnRef);
}
