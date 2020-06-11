package com.edu.online.config;

import com.edu.online.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLoginInterceptor())
                .addPathPatterns("/api/v1/pri/**")
                .excludePathPatterns("/api/v1/pri/user/register", "/api/v1/pri/user/login");
        WebMvcConfigurer.super.addInterceptors(registry);
    }

    public LoginInterceptor getLoginInterceptor() {
        return new LoginInterceptor();
    }
}
