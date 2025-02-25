package com.springboot.asm.fpoly_asm_springboot.service;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductOrderRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductOrderResponse;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Interface định nghĩa các nghiệp vụ xử lý đơn hàng.
 */
public interface OrderService {

    /**
     * Tạo mới đơn hàng.
     *
     * @param order Thông tin đơn hàng cần tạo.
     * @return Đơn hàng đã được tạo.
     */
    ProductOrderResponse createOrder(ProductOrderRequest order);

    /**
     * Lấy thông tin đơn hàng theo ID.
     *
     * @param orderId ID của đơn hàng.
     * @return Đơn hàng tương ứng.
     * @throws RuntimeException nếu không tìm thấy đơn hàng.
     */
    ProductOrderResponse getOrderById(Integer orderId);

    List<ProductOrderResponse> getAllOrdersByUserId(Integer userId);

    Page<ProductOrderResponse> listOrders(int page);

    /**
     * Xác nhận đơn hàng đang ở trạng thái "PENDING".
     *
     * @param orderId ID của đơn hàng cần xác nhận.
     * @return Đơn hàng sau khi cập nhật trạng thái.
     * @throws IllegalStateException nếu trạng thái không cho phép xác nhận.
     */
    ProductOrderResponse confirmOrder(Integer orderId);


    ProductOrderResponse paidOrder(Integer orderId);
    /**
     * Giao hàng cho đơn hàng đang ở trạng thái "PROCESSING".
     *
     * @param orderId ID của đơn hàng cần giao.
     * @return Đơn hàng sau khi cập nhật trạng thái giao hàng.
     * @throws IllegalStateException nếu trạng thái không cho phép giao hàng.
     */
    ProductOrderResponse shipOrder(Integer orderId);

    /**
     * Hoàn tất đơn hàng sau khi khách hàng thanh toán COD và nhận hàng thành công.
     *
     * @param orderId ID của đơn hàng cần hoàn tất.
     * @return Đơn hàng sau khi hoàn tất.
     * @throws IllegalStateException nếu trạng thái không cho phép hoàn tất.
     */
    ProductOrderResponse completeOrder(Integer orderId);

    /**
     * Hủy đơn hàng (ví dụ: khách hàng từ chối nhận hàng).
     *
     * @param orderId ID của đơn hàng cần hủy.
     * @return Đơn hàng sau khi hủy.
     * @throws IllegalStateException nếu trạng thái không cho phép hủy đơn hàng.
     */
    ProductOrderResponse cancelOrder(Integer orderId);
}
