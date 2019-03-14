package com.daxiong.moivebaselib.http;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/2/15
 */
public interface CallbackListener<T> {
    void onSuccess(T t);
    void onFail(String error);
}
