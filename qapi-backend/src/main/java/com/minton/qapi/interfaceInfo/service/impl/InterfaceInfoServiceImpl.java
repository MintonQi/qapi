package com.minton.qapi.interfaceInfo.service.impl;

import com.minton.qapi.interfaceInfo.mapper.InterfaceInfoMapper;
import com.minton.qapi.interfaceInfo.model.InterfaceInfo;
import com.minton.qapi.interfaceInfo.service.InterfaceInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo> implements InterfaceInfoService {
    // The implementation is empty because all methods are either
    // provided by ServiceImpl or defined as default methods in the interface
}
