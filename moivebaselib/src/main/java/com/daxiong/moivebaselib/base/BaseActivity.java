package com.daxiong.moivebaselib.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/8
 */
public class BaseActivity extends AppCompatActivity implements BaseView{
    public Typeface iconfont;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(RootlayoutId());
        iconfont = Typeface.createFromAsset(getAssets(),"font/iconfont.ttf");
        initView();

    }

    @Override
    public int RootlayoutId() {
        return 0;
    }

    @Override
    public boolean isVaildityLogin() {
        return false;
    }

    @Override
    public void initView() {

    }

    @Override
    public void showRequestView() {

    }

    @Override
    public void showPageView() {

    }

    @Override
    public void showHit(String msg) {

    }

    @Override
    public void dismissRequestView() {

    }

    @Override
    public void dismissPageView() {

    }
}
