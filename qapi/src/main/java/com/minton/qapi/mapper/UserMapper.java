package com.minton.qapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minton.qapi.model.User;

public interface UserMapper extends BaseMapper<User> {
    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);
}