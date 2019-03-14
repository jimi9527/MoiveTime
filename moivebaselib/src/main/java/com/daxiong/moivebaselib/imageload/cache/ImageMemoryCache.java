package com.daxiong.moivebaselib.imageload.cache;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2018/12/29
 */
public class ImageMemoryCache {
    private LruCache<String, Bitmap> bitmapLruCache;

    public ImageMemoryCache() {
       initCache();
    }

    private void initCache() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory();
        int cacheSize = maxMemory / 8;

        bitmapLruCache = new LruCache<String, Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                // 每张缓存图片的大小
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap){
        bitmapLruCache.put(url, bitmap);
    }

    public Bitmap get(String url){
      Bitmap bitmap = bitmapLruCache.get(url);
      return bitmap;
    }
}
