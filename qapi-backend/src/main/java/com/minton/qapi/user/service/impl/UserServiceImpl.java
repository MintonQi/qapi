package com.minton.qapi.user.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minton.qapi.user.model.User;
import com.minton.qapi.common.result.ResultCode;
import com.minton.qapi.user.mapper.UserMapper;
import com.minton.qapi.user.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    
    private static final String SALT = "mintonIsBad";

    public void register(User user) {
        // 1. 检查用户是否存在
        User existingUser = getOne(new QueryWrapper<User>().eq("username", user.getUsername()));
        if (existingUser != null) {
            throw new RuntimeException("用户已存在");
        }
        // 加密密码
        String encryptedPassword = DigestUtils.md5DigestAsHex((user.getUserpassword() + SALT).getBytes());
        user.setUserpassword(encryptedPassword);
        // 2. 保存用户
        save(user);
    }

    public User login(String username, String password, HttpServletRequest request) {
        // 1. 查询用户
        String encryptedPassword = DigestUtils.md5DigestAsHex((password + SALT).getBytes());
        User user = getOne(new QueryWrapper<User>()
                .eq("username", username)
                .eq("userpassword", encryptedPassword));

        if (user == null) {
            throw new RuntimeException(ResultCode.USER_NOT_FOUND.getMessage());
        }

        // 2. 保存用户信息到session
        request.getSession().setAttribute("user", user);
        log.info("user " + user.getUsername() + " login");

        return user;
    }
}
