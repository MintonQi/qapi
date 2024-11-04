package com.minton.qapi.common.result;

public enum ResultCode {
    SUCCESS(0, "Success"),
    PARAM_ERROR(40000, "Parameter error"),
    NOT_FOUND(40400, "Resource not found"),
    INTERNAL_ERROR(50000, "Internal server error"),
    DB_ERROR(50100, "Database error"),
    UNKNOWN_ERROR(99999, "Unknown error"),
    USER_NOT_LOGIN(40100, "User not login"),
    USER_NOT_FOUND(40101, "User not found");

    private final int code;
    private final String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
