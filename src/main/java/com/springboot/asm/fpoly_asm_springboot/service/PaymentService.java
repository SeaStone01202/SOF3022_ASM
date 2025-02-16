package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.response.PaymentResponse;
import jakarta.servlet.http.HttpServletRequest;

public interface PaymentService {

    PaymentResponse.VNPayResponse createVnPayPayment(HttpServletRequest request);

    PaymentResponse.VNPayResponse paymentCallBack(String vnp_ResponseCode, String vnp_TxnRef);
}
