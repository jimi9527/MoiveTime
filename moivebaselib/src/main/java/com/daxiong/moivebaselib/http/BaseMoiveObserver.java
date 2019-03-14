package com.daxiong.moivebaselib.http;

import com.daxiong.moivebaselib.http.entity.BaseEntity;

import io.reactivex.observers.DisposableObserver;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/7
 */
public abstract class BaseMoiveObserver<T> extends DisposableObserver<T> {
    private static final int STATUS_OK = 0;

    public abstract void onSuccess(T t);
    public abstract void onFail(String error);


    @Override
    public void onNext(T t) {
       onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
            onFail(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
