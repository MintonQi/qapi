package com.minton.qapi.common.exception;

import com.minton.qapi.common.result.R;
import com.minton.qapi.common.result.ResultCode;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public R<?> handleBusinessException(BusinessException e) {
        return R.error(e.getResultCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public R<?> handleException(Exception e) {
        return R.error(ResultCode.INTERNAL_ERROR, "An unexpected error occurred: " + e.getMessage());
    }
}
