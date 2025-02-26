package com.springboot.asm.fpoly_asm_springboot.controller;

import com.springboot.asm.fpoly_asm_springboot.repositories.primary.OrderDetailRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.ProductOrderRepository;
import com.springboot.asm.fpoly_asm_springboot.repositories.primary.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class DashboardController {

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @GetMapping
    public List<Map<String, Object>> getDashboardData() {
        return List.of(
                Map.of("title", "Tổng Đơn Hàng", "value", 500, "description", "Số đơn hàng đã xử lý.", "bgColor", "bg-dark"),
                Map.of("title", "Doanh Thu", "value", 50000, "description", "Tổng doanh thu từ bán hàng.", "bgColor", "bg-success"),
                Map.of("title", "Số Khách Hàng", "value", 5000, "description", "Số khách hàng đã mua hàng.", "bgColor", "bg-info"),
                Map.of("title", "Số Sản Phẩm", "value", 200, "description", "Tổng số sản phẩm đang bán.", "bgColor", "bg-warning")
        );
    }

    @GetMapping("/revenue-by-category")
    public List<Map<String, Object>> getRevenueByCategory() {
        return orderDetailRepository.getRevenueByCategory();
    }

    @GetMapping("/top-vip-customers")
    public List<Map<String, Object>> getTopVipCustomers() {
        return userRepository.getTopVipCustomers();
    }

}
