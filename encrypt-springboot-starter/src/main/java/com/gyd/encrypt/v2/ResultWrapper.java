package com.gyd.encrypt.v2;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * @ClassName ResultWrapper
 * @Description TODO
 * @Author guoyading
 * @Date 2023/11/23 14:05
 * @Version 1.0
 */
public class ResultWrapper<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int status;
    private String code;
    private T data;
    private String message;

    public ResultWrapper() {
        this.status = StatusCode.OK.value();
        this.message = null;
    }

    public ResultWrapper(String message) {
        this.status = StatusCode.FAILURE.value();
        this.message = message;
    }

    public static ResultWrapper<?> SUCCESS() {
        return new ResultWrapper();
    }

    public static <R> ResultWrapper<R> SUCCESS(R value) {
        return (new ResultWrapper()).setData(value);
    }

    public static ResultWrapper<?> FAILURE(String message) {
        return new ResultWrapper(message);
    }

    public static ResultWrapper<?> FORBIDDEN() {
        ResultWrapper<?> result = new ResultWrapper();
        result.setStatus(StatusCode.NOAUTHORITY.value());
        result.setMessage("forbidden");
        return result;
    }

    public int getStatus() {
        return this.status;
    }

    public ResultWrapper<T> setStatus(int status) {
        this.status = status;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public ResultWrapper<T> setCode(String code) {
        this.code = code;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public ResultWrapper<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return this.message;
    }

    public ResultWrapper<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    @JsonIgnore
    public boolean isSuccess() {
        return this.status == 200;
    }
}