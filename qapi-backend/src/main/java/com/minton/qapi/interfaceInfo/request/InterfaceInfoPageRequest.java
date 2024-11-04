package com.minton.qapi.interfaceInfo.request;

import com.minton.qapi.common.request.BasePageRequest;
import com.minton.qapi.interfaceInfo.model.InterfaceInfo;

public class InterfaceInfoPageRequest extends BasePageRequest {
    private InterfaceInfo filter;

    public InterfaceInfo getFilter() {
        return filter;
    }

    public void setFilter(InterfaceInfo filter) {
        this.filter = filter;
    }
}
