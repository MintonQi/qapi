package com.minton.qapi.interfaceInfo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minton.qapi.interfaceInfo.model.UserInterfaceInfo;

public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    int insertSelective(UserInterfaceInfo record);

    int updateByPrimaryKeySelective(UserInterfaceInfo record);
}