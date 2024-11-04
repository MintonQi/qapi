package com.minton.qapi.interfaceInfo.service;

import com.minton.qapi.common.exception.BusinessException;
import com.minton.qapi.common.result.ResultCode;
import com.minton.qapi.interfaceInfo.model.InterfaceInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    default InterfaceInfo getInterfaceInfoById(Long id) {
        InterfaceInfo interfaceInfo = getById(id);
        if (interfaceInfo == null) {
            throw new BusinessException(ResultCode.NOT_FOUND, "Interface info not found");
        }
        return interfaceInfo;
    }

    default Page<InterfaceInfo> getInterfaceInfoPage(int page, int size, InterfaceInfo filter) {
        Page<InterfaceInfo> pageParam = new Page<>(page, size);
        QueryWrapper<InterfaceInfo> queryWrapper = createQueryWrapperFromInterfaceInfo(filter);
        return page(pageParam, queryWrapper);
    }

    default QueryWrapper<InterfaceInfo> createQueryWrapperFromInterfaceInfo(InterfaceInfo interfaceInfo) {
        QueryWrapper<InterfaceInfo> queryWrapper = new QueryWrapper<>();
        if (interfaceInfo != null) {
            if (interfaceInfo.getName() != null) {
                queryWrapper.like("name", interfaceInfo.getName());
            }
            if (interfaceInfo.getDescription() != null) {
                queryWrapper.like("description", interfaceInfo.getDescription());
            }
            if (interfaceInfo.getUrl() != null) {
                queryWrapper.like("url", interfaceInfo.getUrl());
            }
            if (interfaceInfo.getRequestparams() != null) {
                queryWrapper.like("requestParams", interfaceInfo.getRequestparams());
            }
            if (interfaceInfo.getRequestheader() != null) {
                queryWrapper.like("requestHeader", interfaceInfo.getRequestheader());
            }
            if (interfaceInfo.getResponseheader() != null) {
                queryWrapper.like("responseHeader", interfaceInfo.getResponseheader());
            }
            if (interfaceInfo.getStatus() != null) {
                queryWrapper.eq("status", interfaceInfo.getStatus());
            }
            if (interfaceInfo.getMethod() != null) {
                queryWrapper.eq("method", interfaceInfo.getMethod());
            }
            if (interfaceInfo.getUserid() != null) {
                queryWrapper.eq("userId", interfaceInfo.getUserid());
            }
            if (interfaceInfo.getCreatetime() != null) {
                queryWrapper.ge("createTime", interfaceInfo.getCreatetime());
            }
            if (interfaceInfo.getUpdatetime() != null) {
                queryWrapper.ge("updateTime", interfaceInfo.getUpdatetime());
            }
            if (interfaceInfo.getIsdelete() != null) {
                queryWrapper.eq("is_delete", interfaceInfo.getIsdelete());
            }
        }
        return queryWrapper;
    }

    default boolean updateInterfaceStatus(Long id, Integer status) {
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setId(id);
        interfaceInfo.setStatus(status);
        return updateById(interfaceInfo);
    }
}
