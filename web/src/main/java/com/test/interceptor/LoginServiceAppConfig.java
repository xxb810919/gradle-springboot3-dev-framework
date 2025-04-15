package com.test.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class LoginServiceAppConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 验签拦截
        registry
                .addInterceptor(null)
                // 拦截的路径
                .addPathPatterns("/**")
                .excludePathPatterns("/test/**") // 排除 test 的


        ;
    }
}
