package com.springboot.asm.fpoly_asm_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FpolyAsmSpringbootApplication {

    private FpolyAsmSpringbootApplication() {
    }

    public static void main(String[] args) {
		SpringApplication.run(FpolyAsmSpringbootApplication.class, args);
	}

    public static FpolyAsmSpringbootApplication createFpolyAsmSpringbootApplication() {
        return new FpolyAsmSpringbootApplication();
    }
}
