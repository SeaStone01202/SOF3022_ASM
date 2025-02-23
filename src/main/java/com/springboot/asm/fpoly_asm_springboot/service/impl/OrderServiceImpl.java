package com.springboot.asm.fpoly_asm_springboot.service.impl;

import com.springboot.asm.fpoly_asm_springboot.dto.request.ProductOrderRequest;
import com.springboot.asm.fpoly_asm_springboot.dto.response.ProductOrderResponse;
import com.springboot.asm.fpoly_asm_springboot.entity.ProductOrder;

import com.springboot.asm.fpoly_asm_springboot.entity.User;
import com.springboot.asm.fpoly_asm_springboot.exception.AppException;
import com.springboot.asm.fpoly_asm_springboot.exception.ErrorCode;
import com.springboot.asm.fpoly_asm_springboot.mapper.OrderProductMapper;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.ProductOrderRepository;

import com.springboot.asm.fpoly_asm_springboot.repositories.primary.UserRepository;
import com.springboot.asm.fpoly_asm_springboot.service.OrderService;
import com.springboot.asm.fpoly_asm_springboot.util.PageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final ProductOrderRepository orderRepository;
    private final OrderProductMapper orderProductMapper;
    private final PageUtil pageUtil;
    private final UserRepository UserRepository;
    private final UserRepository userRepository;

    /**
     * Tạo đơn hàng mới từ thông tin yêu cầu.
     * - Chuyển đổi từ DTO sang Entity.
     * - Thiết lập trạng thái mặc định là "PENDING" và thời gian đặt hàng hiện tại.
     * - Lưu xuống CSDL và chuyển đổi lại thành DTO cho phản hồi.
     */
    @Override
    @Transactional
    public ProductOrderResponse createOrder(ProductOrderRequest orderRequest) {

        ProductOrder order = orderProductMapper.toProductOrder(orderRequest);
        User user = userRepository.findById(orderRequest.getUserId())
                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        order.setStatus("PENDING");
        order.setUser(user);
        order.setOrderDate(new Date(System.currentTimeMillis()));
        ProductOrder savedOrder = orderRepository.save(order);
        return orderProductMapper.toProductOrderResponse(savedOrder);
    }

    /**
     * Lấy thông tin đơn hàng theo ID.
     * Nếu không tìm thấy, ném ngoại lệ OrderNotFoundException.
     */
    @Override
    @Transactional(readOnly = true)
    public ProductOrderResponse getOrderById(Integer orderId) {
        return orderProductMapper.toProductOrderResponse(
                orderRepository.findById(orderId)
                        .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND)));
    }

    @Override
    public List<ProductOrderResponse> getAllOrdersByUserId(Integer userId) {
        return orderRepository.findByUserId(userId).stream().map(orderProductMapper::toProductOrderResponse).toList();
    }

    /**
     * Lấy danh sách đơn hàng dạng phân trang.
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ProductOrderResponse> listOrders(int page) {
        Pageable pageable = pageUtil.createPageable(page);
        return orderRepository.findAll(pageable)
                .map(orderProductMapper::toProductOrderResponse);
    }

    /**
     * Xác nhận đơn hàng:
     * - Chỉ cho phép xác nhận khi đơn hàng ở trạng thái "PENDING".
     * - Sau xác nhận, cập nhật trạng thái thành "PROCESSING".
     */
    @Override
    @Transactional
    public ProductOrderResponse confirmOrder(Integer orderId) {
        ProductOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        if (!"PENDING".equals(order.getStatus())) {
            throw new AppException(ErrorCode.ORDER_NOT_SPENDING);
        }
        order.setStatus("PROCESSING");
        return orderProductMapper.toProductOrderResponse(orderRepository.save(order));
    }

    @Override
    public ProductOrderResponse paidOrder(Integer orderId) {
        ProductOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        if (!"PENDING".equals(order.getStatus())) {
            throw new AppException(ErrorCode.ORDER_NOT_SPENDING);
        }
        order.setStatus("PAID");
        return orderProductMapper.toProductOrderResponse(orderRepository.save(order));
    }

    /**
     * Giao đơn hàng:
     * - Chỉ cho phép giao hàng khi đơn hàng đang ở trạng thái "PROCESSING".
     * - Sau đó cập nhật trạng thái thành "SHIPPING".
     */
    @Override
    @Transactional
    public ProductOrderResponse shipOrder(Integer orderId) {
        ProductOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        if (!"PROCESSING".equals(order.getStatus())) {
            throw new AppException(ErrorCode.ORDER_NOT_PROCESSING);
        }
        order.setStatus("SHIPPING");
        return orderProductMapper.toProductOrderResponse(orderRepository.save(order));
    }

    /**
     * Hoàn tất đơn hàng:
     * - Chỉ cho phép hoàn tất khi đơn hàng đang ở trạng thái "SHIPPING".
     * - Sau khi khách hàng nhận hàng và thanh toán COD thành công, cập nhật trạng thái thành "COMPLETED".
     */
    @Override
    @Transactional
    public ProductOrderResponse completeOrder(Integer orderId) {
        ProductOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        if (!"SHIPPING".equals(order.getStatus())) {
            throw new AppException(ErrorCode.ORDER_NOT_SHIPPING);
        }
        order.setStatus("COMPLETED");
        return orderProductMapper.toProductOrderResponse(orderRepository.save(order));

    }

    /**
     * Hủy đơn hàng:
     * - Nếu đơn hàng đã hoàn tất thì không thể hủy.
     * - Cập nhật trạng thái thành "CANCELLED" cho các đơn hàng chưa hoàn tất.
     */
    @Override
    @Transactional
    @PreAuthorize("hasRole('USER')")
    public ProductOrderResponse cancelOrder(Integer orderId) {
        ProductOrder order = orderRepository.findById(orderId)
                .orElseThrow(() -> new AppException(ErrorCode.ORDER_NOT_FOUND));
        if ("COMPLETED".equals(order.getStatus())) {
            throw new AppException(ErrorCode.ORDER_NOT_CANCEL);
        }
        order.setStatus("CANCELLED");
        return orderProductMapper.toProductOrderResponse(orderRepository.save(order));
    }
}
