package com.daxiong.moivebaselib.imageload.cache;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;

import com.daxiong.moivebaselib.util.FileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2018/12/29
 */
public class DiskCache {
    private Context context;
    private File cacheFile;

    public DiskCache(Context context) {
        this.context = context;
    }

    public void put(String url, Bitmap bitmap){
        // 新建文件
        cacheFile = FileUtil.getSaveFile(context, url);
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(cacheFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Bitmap get(String fileName){
        String path = FileUtil.getFile(fileName, context);
        if(!TextUtils.isEmpty(path)){
            return BitmapFactory.decodeFile(path);
        }else {
            return null;
        }
    }
}
