package com.tuya.common.pojo;

public enum ErrorCode {
    ERROR_SUCCESS("20000", "处理成功")
    ,ERROR_SERVER_ERROR("50001", "内部服务错误")
    ,ERROR_SQL_PARSE("40001", "sql解析异常")
    ,ERROR_FAILED("99999", "通用失败")
    ;
    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
