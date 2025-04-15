package com.test.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Objects;

@ControllerAdvice
@Slf4j
public class SvrResponseAdvice implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class converterType) {
        Annotation restAnnotation = Arrays.stream(methodParameter.getDeclaringClass().getAnnotations())
                .filter(annotation -> annotation instanceof RestController)
                .findAny().orElse(null);


        if (Objects.nonNull(restAnnotation) || methodParameter.hasMethodAnnotation(ResponseBody.class)) {
            return true;
        }

        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class selectedConverterType,
                                  ServerHttpRequest request,
                                  ServerHttpResponse response) {
        return body;


    }
}
