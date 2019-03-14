package com.daxiong.moivebaselib.http.entity;

import java.io.Serializable;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/6
 */
public class BaseToday<T> implements Serializable {
    private int error_code;
    private String reason;
    private T result;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
