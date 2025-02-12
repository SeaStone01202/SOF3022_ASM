package com.springboot.asm.fpoly_asm_springboot.config.cloudinary;


import com.cloudinary.Cloudinary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary() {
        Map<String, String> config = new HashMap();
        config.put("cloud_name", "dpbysnmcc");
        config.put("api_key", "652244894287299");
        config.put("api_secret", "VFXiAf6zQ0ygfdfe_t9Vm0eMOuc");
        return new Cloudinary(config);
    }
}
