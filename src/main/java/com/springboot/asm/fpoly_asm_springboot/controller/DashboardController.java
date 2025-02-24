package com.springboot.asm.fpoly_asm_springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class DashboardController {

    @GetMapping
    public List<Map<String, Object>> getDashboardData() {
        return List.of(
                Map.of("title", "Tổng Đơn Hàng", "value", 500, "description", "Số đơn hàng đã xử lý.", "bgColor", "bg-dark"),
                Map.of("title", "Doanh Thu", "value", "$50,000", "description", "Tổng doanh thu từ bán hàng.", "bgColor", "bg-success"),
                Map.of("title", "Số Khách Hàng", "value", 5000, "description", "Số khách hàng đã mua hàng.", "bgColor", "bg-info"),
                Map.of("title", "Số Sản Phẩm", "value", 200, "description", "Tổng số sản phẩm đang bán.", "bgColor", "bg-warning")
        );
    }
}
