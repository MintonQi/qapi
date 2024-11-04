package com.minton.qapi.common.exception;

import com.minton.qapi.common.result.ResultCode;

import lombok.Getter;

@Getter
public class BusinessException extends RuntimeException {
    private ResultCode resultCode;

    public BusinessException(ResultCode resultCode, String message) {
        super(message);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }
}
