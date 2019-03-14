package com.daxiong.moivebaselib.imageload;

import android.net.Uri;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/14
 */
public class FrescoWebploader {


    public void load(String url, SimpleDraweeView simpleDraweeView){
        Uri uri = Uri.parse(url);
        simpleDraweeView.setImageURI(uri);
    }
}
