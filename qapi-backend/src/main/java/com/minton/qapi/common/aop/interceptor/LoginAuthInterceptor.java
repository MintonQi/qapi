package com.minton.qapi.common.aop.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.minton.qapi.common.aop.AdminCheck;
import com.minton.qapi.common.result.ResultCode;
import com.minton.qapi.user.model.User;

import cn.hutool.json.JSONUtil;

@Component
@Slf4j
public class LoginAuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        // 拦截所有带有注解@AdminCheck 的请求
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AdminCheck adminCheck = handlerMethod.getMethodAnnotation(AdminCheck.class);
            if (adminCheck != null) {
                User user = (User) request.getSession().getAttribute("user");
                log.info("user = " + JSONUtil.toJsonStr(user));
                if (user == null) {
                    throw new RuntimeException(ResultCode.USER_NOT_LOGIN.getMessage());
                }
            }
        }
        return true;
    }
}
