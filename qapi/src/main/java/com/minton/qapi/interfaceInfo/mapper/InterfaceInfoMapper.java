package com.minton.qapi.interfaceInfo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minton.qapi.interfaceInfo.model.InterfaceInfo;

public interface InterfaceInfoMapper extends BaseMapper<InterfaceInfo> {
    int insertSelective(InterfaceInfo record);

    int updateByPrimaryKeySelective(InterfaceInfo record);
}