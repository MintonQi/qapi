package com.minton.qapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.minton.qapi.model.InterfaceInfo;

public interface InterfaceInfoMapper extends BaseMapper<InterfaceInfo> {
    int insertSelective(InterfaceInfo record);

    int updateByPrimaryKeySelective(InterfaceInfo record);
}