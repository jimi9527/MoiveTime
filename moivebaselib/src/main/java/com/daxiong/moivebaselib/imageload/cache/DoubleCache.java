package com.daxiong.moivebaselib.imageload.cache;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2018/12/29
 */
public class DoubleCache {
    private Context context;
    private ImageMemoryCache memoryCache;
    private DiskCache diskCache;

    public DoubleCache(Context context) {
        this.context = context;
        memoryCache = new ImageMemoryCache();
        diskCache = new DiskCache(context);
    }

    public Bitmap get(String url){
        Bitmap bitmap = memoryCache.get(url);
        if(null == bitmap){
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }
}
