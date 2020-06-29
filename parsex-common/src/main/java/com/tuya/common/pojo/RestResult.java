package com.tuya.common.pojo;

import java.sql.Timestamp;

public class RestResult<T> {
    private String code;
    private String message;
    private T data;
    private Timestamp currentTime;

    private RestResult() {
        this.currentTime = new Timestamp(System.currentTimeMillis());
    }

    public static <T> RestResult<T> newInstance() {
        return new RestResult<>();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", currentTime=" + currentTime +
                '}';
    }
}
