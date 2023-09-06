package com.ticserver.server.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CROSOrigin implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*") // Adjust the URL pattern as needed
                .allowedOrigins("*") // Allow requests from your React app's domain
                .allowedMethods("GET", "POST", "PUT", "DELETE") // Allowed HTTP methods
                .allowedHeaders("Origin", "Content-Type", "Accept", "Authorization") // Allowed headers
                .allowCredentials(true); // Allow credentials (e.g., cookies)
    }
}
