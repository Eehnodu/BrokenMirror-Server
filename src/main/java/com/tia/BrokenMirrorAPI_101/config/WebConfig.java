package com.tia.BrokenMirrorAPI_101.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // "profile" 디렉토리를 URL 경로 "/profile/**"로 매핑
        registry.addResourceHandler("/profile/**")
                .addResourceLocations("file:profile/");
    }
}

