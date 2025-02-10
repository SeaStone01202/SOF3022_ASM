package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.response.PaymentResponse;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.service.CartService;
import com.springboot.asm.fpoly_asm_springboot.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;
    private final CartService cartService;

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
    public ApiResponse<PaymentResponse.VNPayResponse> payCallbackHandler(HttpServletRequest request) {

        String status = request.getParameter("vnp_ResponseCode");

        var emailUser = SecurityContextHolder.getContext().getAuthentication().getName();

        if (status.equals("00")) {
            cartService.clearAfterPayment(emailUser);
            return ApiResponse.<PaymentResponse.VNPayResponse>builder().
                    message("Successfully").
                    result(PaymentResponse.VNPayResponse.builder().
                            code("00").
                            message("Success").
                            build()).
                    build();
        } else {
            throw new AppException(ErrorCode.RESPONSE_NOT_FOUND);
        }
    }
}
