package com.daxiong.moivebaselib.imageload;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import com.daxiong.moivebaselib.imageload.cache.DoubleCache;
import com.daxiong.moivebaselib.util.FileUtil;
import com.daxiong.moivebaselib.util.MD5Util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2018/12/29
 */
public class ImageLoder {

    private String path;
    private Context context;
    private ImageView imageView;

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {

            }

        }
    };

    private LoaderListener mLoaderListener;


    public void setmLoaderListener(LoaderListener mLoaderListener) {
        this.mLoaderListener = mLoaderListener;
    }

    public interface LoaderListener {
        void onLoadSuccess(Bitmap bitmap);

        void onLoadFail(String msg);
    }

    public static final ImageLoder getInstance() {
        return SingleImage.instance;
    }

    private static class SingleImage {
        private static final ImageLoder instance = new ImageLoder();
    }

    public void showImage(Context context, ImageView imageView, String url) {
        this.path = url;
        this.context = context;
        this.imageView = imageView;
        String fileName = MD5Util.string2MD5(url) + ".png";
        DoubleCache doubleCache = new DoubleCache(context);
        Bitmap bitmap = doubleCache.get(fileName);
        if (bitmap == null) {

            ThreadPoolUtil.getInstance().excute(new DownloadRunnable());

        } else {
            imageView.setImageBitmap(bitmap);
        }
    }

    public void showImage(Context context, ImageView imageView, String url, LoaderListener loaderListener){
         this.showImage(context, imageView, url);
    }

    class DownloadRunnable implements Runnable {
        @Override
        public void run() {
            final Bitmap bitmap = download(path);
            handler.post(new Runnable() {
                @Override
                public void run() {
                    imageView.setImageBitmap(bitmap);
                }
            });
            save(bitmap);
        }
    }

    // save
    private void save(Bitmap bitmap) {
        if(bitmap == null){
            return;
        }
        String fileName = MD5Util.string2MD5(path) + ".png";
        File file = FileUtil.SaveFile(context, fileName);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Bitmap download(String path) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(path);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5 * 1000);
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int len;
                while ((len = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, len);
                }
                outputStream.close();
                inputStream.close();

                byte[] byteArray = outputStream.toByteArray();
                bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

                if (mLoaderListener != null) {
                    mLoaderListener.onLoadSuccess(bitmap);
                }
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
            if (mLoaderListener != null) {
                mLoaderListener.onLoadFail(e.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
            if (mLoaderListener != null) {
                mLoaderListener.onLoadFail(e.getMessage());
            }
        }
        return bitmap;
    }

}
