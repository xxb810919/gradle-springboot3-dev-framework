package com.test.common.configuration;


import com.test.common.interceptor.MultipartSignCheckInterceptor;
import com.test.common.interceptor.SignCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;


@Configuration
public class DesignerWebMvcConfig implements WebMvcConfigurer {


    @Autowired
    private SignCheckInterceptor signCheckInterceptor;

    @Autowired
    private MultipartSignCheckInterceptor multipartSignCheckInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 验签拦截
        registry.addInterceptor(signCheckInterceptor)
                // 拦截的路径
                .addPathPatterns("/**")
                // 排除登录等接口
                .excludePathPatterns("/test/**")
                // 排除上传接口
                .excludePathPatterns("/file/**")
        ;


        registry.addInterceptor(multipartSignCheckInterceptor)
                .addPathPatterns("/file/upload");


    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(0, new MappingJackson2HttpMessageConverter());

    }

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 设置是否忽略路径末尾的斜杠
        configurer.setUseTrailingSlashMatch(true);
    }
}
