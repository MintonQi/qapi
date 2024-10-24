package com.minton.qapi.user.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.minton.qapi.user.model.User;
import com.minton.qapi.user.mapper.UserMapper;
import com.minton.qapi.user.service.UserService;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    // You can add additional methods or override existing ones here if needed
}
