package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.springboot.asm.fpoly_asm_springboot.config.payment.VNPAYConfig;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.PaymentResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductOrderResponse;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.service.OrderService;
import com.springboot.asm.fpoly_asm_springboot.service.PaymentService;
import com.springboot.asm.fpoly_asm_springboot.util.VNPayUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final VNPAYConfig vnPayConfig;

    private final OrderService orderService;

    @Override
    public PaymentResponse.VNPayResponse createVnPayPayment(HttpServletRequest request) {
        long amount = Integer.parseInt(request.getParameter("amount")) * 100L;
        String bankCode = request.getParameter("bankCode");

        String orderId = request.getParameter("orderId");

        Map<String, String> vnpParamsMap = vnPayConfig.getVNPayConfig(orderId);

        vnpParamsMap.put("vnp_Amount", String.valueOf(amount));
        if (bankCode != null && !bankCode.isEmpty()) {
            vnpParamsMap.put("vnp_BankCode", bankCode);
        }
        vnpParamsMap.put("vnp_IpAddr", VNPayUtil.getIpAddress(request));

        String queryUrl = VNPayUtil.getPaymentURL(vnpParamsMap, true);
        String hashData = VNPayUtil.getPaymentURL(vnpParamsMap, false);
        String vnpSecureHash = VNPayUtil.hmacSHA512(vnPayConfig.getSecretKey(), hashData);
        queryUrl += "&vnp_SecureHash=" + vnpSecureHash;
        String paymentUrl = vnPayConfig.getVnp_PayUrl() + "?" + queryUrl;


        return PaymentResponse.VNPayResponse.builder()
                .code("ok")
                .message("success")
                .paymentUrl(paymentUrl).build();
    }

    @Override
    public ProductOrderResponse paymentCallBack(String vnp_ResponseCode, String vnp_TxnRef) {
        if (vnp_TxnRef == null) {
            throw new AppException(ErrorCode.ORDER_NOT_FOUND);
        }

        Integer orderId = Integer.parseInt(vnp_TxnRef);
        
        orderService.paidOrder(orderId);

        if (vnp_ResponseCode.equals("00")) {
            return orderService.getOrderById(orderId);
        } else {
            throw new AppException(ErrorCode.RESPONSE_NOT_FOUND);
        }
    }
}
