package com.daxiong.moivebaselib.base;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/7
 */
public interface BaseView {


    /**
     * resId
     */
    int RootlayoutId();

    /**
     * 是否登陆
      * @return
     */
    boolean isVaildityLogin();
    /**
     * 初始化
     */
    void initView();

    /**
     * 请求加载框
     */
    void showRequestView();

    /**
     * 页面加载框
     */
    void showPageView();

    /**
     * 提示框
     */
    void showHit(String msg);

    /**
     * 关闭请求加载框
     */
    void dismissRequestView();

    /**
     * 关闭页面加载框
     */
    void dismissPageView();
}
