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
import com.minton.qapi.user.enums.UserRoleEnum;

@Component
@Slf4j
public class LoginAuthInterceptor implements HandlerInterceptor {

    private String env = System.getProperty("env", "dev"); // Default to "prod" if not set

    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        // 拦截所有请求校验是否登录
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            throw new RuntimeException(ResultCode.USER_NOT_LOGIN.getMessage());
        }
        // 拦截所有带有注解@AdminCheck 的请求
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            AdminCheck adminCheck = handlerMethod.getMethodAnnotation(AdminCheck.class);
            if (adminCheck != null) {
                if (!user.getUserrole().equals(UserRoleEnum.ADMIN.getRole())) {
                    // 开发环境直接放行
                    if (env.equals("dev")) {
                        return true;
                    }
                    throw new RuntimeException(ResultCode.NO_AUTH.getMessage());
                }
            }
        }
        return true;
    }
}
