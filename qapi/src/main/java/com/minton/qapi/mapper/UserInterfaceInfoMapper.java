package com.minton.qapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minton.qapi.model.UserInterfaceInfo;

public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    int insertSelective(UserInterfaceInfo record);

    int updateByPrimaryKeySelective(UserInterfaceInfo record);
}