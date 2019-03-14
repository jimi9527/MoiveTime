package com.daxiong.moivebaselib.util;

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2018/12/27
 */
public class FileUtil {
    private final static String TAG = "FileUtil";

    // 新建文件
    public static File getSaveFile(Context context, String fileName) {
        File file = new File(context.getExternalCacheDir(), fileName);
        Log.d(TAG, "file.getAbsolutePath():" + file.getAbsolutePath());
        if (file.exists()) {
            file.delete();
        }
        try {
            file.createNewFile();
            Log.d(TAG, "file.createNewFile success");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "file.createNewFile fail");
        }

        return file;
    }

    // 保存文件
    public static File SaveFile(Context context, String fileName) {
        File file = new File(context.getExternalCacheDir(), fileName);
        Log.d(TAG, "file.getAbsolutePath():" + file.getAbsolutePath());
        if (!file.exists()) {
            try {
                file.createNewFile();
                Log.d(TAG, "file.createNewFile success");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d(TAG, "file.createNewFile fail");
            }
        }
        return file;
    }

    // 获取文件
    public static String getFile(String fileName, Context context){
        File file = new File(context.getExternalCacheDir(), fileName);
        if(file.exists()){
            return file.getAbsolutePath();
        }else {
            return null;
        }
    }



    //byte save 文件

    public static void dumpFile(File file, byte[] bytes){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, "init fileoutputstream success");
        } catch (IOException e) {
            e.printStackTrace();
            Log.d(TAG, "fileoutputstream write exception");
        }
    }

}
