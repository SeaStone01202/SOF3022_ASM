package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.PaymentResponse;
import com.springboot.asm.fpoly_asm_springboot.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

//    Thẻ test:
//    Ngân hàng	NCB
//    Số thẻ	9704198526191432198
//    Tên chủ thẻ	NGUYEN VAN A
//    Ngày phát hành	07/15
//    Mật khẩu OTP	123456

    @GetMapping("/vn-pay")
    public ApiResponse<PaymentResponse.VNPayResponse> pay(HttpServletRequest request) {
        return ApiResponse.<PaymentResponse.VNPayResponse>builder().
                message("Succesfull").
                result(paymentService.createVnPayPayment(request)).
                build();
    }

    @GetMapping("/vn-pay-callback")
    public ApiResponse<?> payCallbackHandler(
            @RequestParam String vnp_ResponseCode,
            @RequestParam String vnp_TxnRef) {
        return ApiResponse.builder()
                .result(paymentService.paymentCallBack(vnp_ResponseCode, vnp_TxnRef).getStatus())
                .build();
    }
}
