package com.daxiong.moivebaselib.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/8
 */
public abstract class MvpBaseActivity<V extends BaseView, P extends BasePresenter<V>> extends BaseActivity {

    protected  P presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(presenter != null){
            presenter.attachView((V) this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(presenter != null){
            presenter.detachView();
            presenter.cancle();
        }
    }

    protected P getPresenter(){
        if (presenter == null) {
            presenter = createPresenter();
        }
        return presenter;
    }

    public abstract  P createPresenter();
}
