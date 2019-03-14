package com.daxiong.moivebaselib.http.entity;
import java.io.Serializable;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/2/19
 */
public class BaseEntity<T> implements Serializable {
    private int status;
    private T data;
    private String message;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
