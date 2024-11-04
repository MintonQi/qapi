package com.minton.qapi.common.result;

import lombok.Data;

@Data
public class R<T> {
    private int code;
    private String message;
    private T data;

    private R(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public static <T> R<T> success(T data) {
        return new R<>(ResultCode.SUCCESS, data);
    }

    public static <T> R<T> error(ResultCode resultCode) {
        return new R<>(resultCode, null);
    }

    public static <T> R<T> error(ResultCode resultCode, String message) {
        R<T> r = new R<>(resultCode, null);
        r.setMessage(message);
        return r;
    }
}
