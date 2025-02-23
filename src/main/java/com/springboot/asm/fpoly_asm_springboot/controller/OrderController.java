package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ApiResponse;
import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductOrderRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductOrderResponse;
import com.springboot.asm.fpoly_asm_springboot.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/all/{userId}")
    public List<ProductOrderResponse> listOrdersByUserId(@PathVariable Integer userId) {
        return orderService.getAllOrdersByUserId(userId);
    }


    @GetMapping
    public Page<ProductOrderResponse> listOrders(@RequestParam int page) {
        return orderService.listOrders(page);
    }

    /**
     * Tạo đơn hàng mới.
     * POST /order
     *
     * @param orderRequest thông tin đơn hàng từ client
     * @return ProductOrderResponse chứa thông tin đơn hàng được tạo
     */
    @PostMapping
    public ApiResponse<ProductOrderResponse> createOrder(@RequestBody ProductOrderRequest orderRequest) {
        return ApiResponse.<ProductOrderResponse>builder()
                .result(orderService.createOrder(orderRequest)).
                build();
    }

    /**
     * Lấy thông tin đơn hàng theo ID.
     * GET /order/{orderId}
     *
     * @param orderId mã định danh của đơn hàng
     * @return ProductOrderResponse chứa thông tin đơn hàng
     */
    @GetMapping("/{orderId}")
    public ApiResponse<ProductOrderResponse> getOrderById(@PathVariable Integer orderId) {
        return ApiResponse.<ProductOrderResponse>builder()
                .result(orderService.getOrderById(orderId))
                .build();
    }

    /**
     * Xác nhận đơn hàng (chuyển trạng thái từ PENDING sang PROCESSING).
     * PUT /order/{orderId}/confirm
     *
     * @param orderId mã định danh của đơn hàng cần xác nhận
     * @return ProductOrderResponse chứa thông tin đơn hàng sau khi xác nhận
     */
    @PutMapping("/{orderId}/confirm")
    public ApiResponse<ProductOrderResponse> confirmOrder(@PathVariable Integer orderId) {
        return ApiResponse.<ProductOrderResponse>builder()
                .result(orderService.confirmOrder(orderId))
                .build();
    }

    /**
     * Giao đơn hàng (chuyển trạng thái từ PROCESSING sang SHIPPING).
     * PUT /order/{orderId}/ship
     *
     * @param orderId mã định danh của đơn hàng cần giao
     * @return ProductOrderResponse chứa thông tin đơn hàng sau khi chuyển sang trạng thái SHIPPING
     */
    @PutMapping("/{orderId}/ship")
    public ApiResponse<ProductOrderResponse> shipOrder(@PathVariable Integer orderId) {
        return ApiResponse.<ProductOrderResponse>builder()
                .result(orderService.shipOrder(orderId))
                .build();
    }

    /**
     * Hoàn tất đơn hàng (chuyển trạng thái từ SHIPPING sang COMPLETED).
     * PUT /order/{orderId}/complete
     *
     * @param orderId mã định danh của đơn hàng cần hoàn tất
     * @return ProductOrderResponse chứa thông tin đơn hàng sau khi hoàn tất
     */
    @PutMapping("/{orderId}/complete")
    public ApiResponse<ProductOrderResponse> completeOrder(@PathVariable Integer orderId) {
        return ApiResponse.<ProductOrderResponse>builder()
                .result(orderService.completeOrder(orderId))
                .build();
    }

    /**
     * Hủy đơn hàng (chuyển trạng thái sang CANCELLED, nếu đơn hàng chưa COMPLETED).
     * PUT /order/{orderId}/cancel
     *
     * @param orderId mã định danh của đơn hàng cần hủy
     * @return ProductOrderResponse chứa thông tin đơn hàng sau khi hủy
     */
    @PutMapping("/{orderId}/cancel")
    public ApiResponse<ProductOrderResponse> cancelOrder(@PathVariable Integer orderId) {
        return ApiResponse.<ProductOrderResponse>builder()
                .result(orderService.cancelOrder(orderId))
                .build();
    }
}
