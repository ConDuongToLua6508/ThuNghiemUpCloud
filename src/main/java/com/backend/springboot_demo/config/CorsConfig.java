package com.backend.springboot_demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Đánh dấu đây là file cấu hình để Spring Boot tự động load khi chạy
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**") // Áp dụng cho mọi API có tiền tố là /api/
                .allowedOrigins("http://127.0.0.1:5500", "http://localhost:5500") // Cho phép Frontend từ các nguồn này
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Cho phép các hành động
                .allowedHeaders("*") // Cho phép gửi mọi loại Header (như Token, Content-Type)
                .allowCredentials(true); // Cho phép gửi Cookie/Session (nếu có)
    }
}
