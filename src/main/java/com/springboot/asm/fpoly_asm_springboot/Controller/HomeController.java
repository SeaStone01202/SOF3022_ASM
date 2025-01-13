package com.springboot.asm.fpoly_asm_springboot.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/api/v1/home")
    public String home() {
        return "Home";
    }
}
