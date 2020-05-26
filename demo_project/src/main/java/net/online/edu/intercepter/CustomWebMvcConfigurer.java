package net.online.edu.intercepter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CustomWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(getCustomLoginInterceptor()).addPathPatterns("/api/v1/pri/**");

        WebMvcConfigurer.super.addInterceptors(registry);
    }


    @Bean
    public CustomLoginInterceptor getCustomLoginInterceptor() {
        return new CustomLoginInterceptor();
    }
}
