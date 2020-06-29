package com.tuya.common.pojo;

public class RestResultGenerator {
    public static <T> RestResult<T> genResult(ErrorCode errorCode, T data, String message) {
        RestResult<T> result = RestResult.newInstance();
        result.setCode(errorCode.getCode());
        result.setData(data);
        result.setMessage(message);
        return result;
    }

    public static <T> RestResult<T> genSuccessResult(T data) {
        return genResult(ErrorCode.ERROR_SUCCESS, data, ErrorCode.ERROR_SUCCESS.getMessage());
    }

    public static <T> RestResult<T> genErrorResult(String message) {
        return genResult(ErrorCode.ERROR_FAILED, null, message);
    }

    public static <T> RestResult<T> genErrorResult(ErrorCode error) {
        return genResult(error, null,  error.getMessage());
    }

    public static <T> RestResult<T> genErrorResult(ErrorCode error, String message) {
        return genResult(error, null,  message);
    }

    public static RestResult genSuccessResult() {
        return genSuccessResult(null);
    }
}
