package com.test.common.sign;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * 验证方法
 */
public interface SignVerifyService {

    boolean signCheckMultipart(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception;

}
