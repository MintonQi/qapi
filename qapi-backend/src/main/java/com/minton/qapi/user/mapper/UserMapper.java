package com.minton.qapi.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minton.qapi.user.model.User;

public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);
}