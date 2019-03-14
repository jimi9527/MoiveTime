package com.daxiong.moivebaselib.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/8
 */
public class BaseFragemnt extends Fragment implements BaseView {
    public View mRootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = inflater.inflate(RootlayoutId(), container, false);
        initView();
        return mRootView;
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
