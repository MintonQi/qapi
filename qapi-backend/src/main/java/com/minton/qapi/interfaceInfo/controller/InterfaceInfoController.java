package com.minton.qapi.interfaceInfo.controller;

import com.minton.qapi.common.aop.AdminCheck;
import com.minton.qapi.common.request.StatusUpdateRequest;
import com.minton.qapi.common.result.R;
import com.minton.qapi.common.result.ResultCode;
import com.minton.qapi.interfaceInfo.model.InterfaceInfo;
import com.minton.qapi.interfaceInfo.request.InterfaceInfoPageRequest;
import com.minton.qapi.interfaceInfo.service.impl.InterfaceInfoServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interfaceInfo")
public class InterfaceInfoController {

    @Autowired
    private InterfaceInfoServiceImpl interfaceInfoService;

    @PostMapping
    @AdminCheck
    public R<InterfaceInfo> createInterfaceInfo(@RequestBody InterfaceInfo interfaceInfo) {
        boolean saved = interfaceInfoService.save(interfaceInfo);
        return saved ? R.success(interfaceInfo) : R.error(ResultCode.INTERNAL_ERROR, "Failed to create interface info");
    }

    @PutMapping("/{id}")
    @AdminCheck
    public R<InterfaceInfo> updateInterfaceInfo(@PathVariable Long id, @RequestBody InterfaceInfo interfaceInfo) {
        interfaceInfo.setId(id);
        boolean updated = interfaceInfoService.updateById(interfaceInfo);
        return updated ? R.success(interfaceInfo) : R.error(ResultCode.INTERNAL_ERROR, "Failed to update interface info");
    }

    @DeleteMapping("/{id}")
    @AdminCheck
    public R<Boolean> deleteInterfaceInfo(@PathVariable Long id) {
        boolean deleted = interfaceInfoService.removeById(id);
        return R.success(deleted);
    }

    @GetMapping("/{id}")
    @AdminCheck
    public R<InterfaceInfo> getInterfaceInfo(@PathVariable Long id) {
        InterfaceInfo info = interfaceInfoService.getInterfaceInfoById(id);
        return R.success(info);
    }

    @GetMapping
    public R<Page<InterfaceInfo>> listInterfaceInfos(InterfaceInfoPageRequest queryForm) {
        Page<InterfaceInfo> pageResult = interfaceInfoService.getInterfaceInfoPage(
            queryForm.getPage(), queryForm.getSize(), queryForm.getFilter());
        return R.success(pageResult);
    }

    /**
     * 更新接口状态为在线或下线
     */
    @AdminCheck
    @PatchMapping("/{id}/status")
    public R<Boolean> updateInterfaceStatus(@PathVariable Long id, @RequestBody StatusUpdateRequest statusUpdate) {
        boolean updated = interfaceInfoService.updateInterfaceStatus(id, statusUpdate.getStatus());
        return R.success(updated);
    }
}


