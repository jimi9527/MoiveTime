package com.daxiong.moivebaselib.util;

import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import android.util.Log;

import java.nio.ByteBuffer;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2018/12/28
 */
public class ImageUtil {
    private final static String TAG = "ImageUtil";
    private static final int COLOR_FormatI420 = 1;
    private static final int COLOR_FormatNV21 = 2;

    public static byte[] getDataFormImage(Image image, int colorFormat){
       /* if( colorFormat != ImageFormat.NV21 && colorFormat != ImageFormat.YV12){
            throw new IllegalArgumentException("current ImageFormat not support");
        }*/
        Rect crop = image.getCropRect();
        int format = image.getFormat();
        int width = crop.width();
        int height = crop.height();

        Image.Plane[] planes = image.getPlanes();
        byte[] data = new byte[width * height * ImageFormat.getBitsPerPixel(format) / 8];

        byte[] rowData = new byte[planes[0].getRowStride()];
        Log.d(TAG, "rowData.length" + rowData.length);

        int channelOffest = 0;
        int outputSize = 0;

        for(int i = 0; i < planes.length; i++){
            switch (i){
                case 0:
                    channelOffest = 0;
                    outputSize = 1;
                    break;
                case 1:
                    if (colorFormat == COLOR_FormatI420) {
                        channelOffest = width * height;
                        outputSize = 1;
                    } else if (colorFormat == COLOR_FormatNV21) {
                        channelOffest = width * height + 1;
                        outputSize = 2;
                    }
                    break;
                case 2:
                    if (colorFormat == COLOR_FormatI420) {
                        channelOffest = (int) (width * height * 1.25);
                        outputSize = 1;
                    } else if (colorFormat == COLOR_FormatNV21) {
                        channelOffest = width * height;
                        outputSize = 2;
                    }
                    break;
            }
            ByteBuffer buffer = planes[i].getBuffer();
            int rowStride = planes[i].getRowStride();
            int pixelStride = planes[i].getPixelStride();
            Log.d(TAG, "pixelStride " + pixelStride);
            Log.d(TAG, "rowStride " + rowStride);
            Log.d(TAG, "width " + width);
            Log.d(TAG, "height " + height);
            Log.d(TAG, "buffer size " + buffer.remaining());

            int shift = (i == 0) ? 0 : 1;
            int w = width >> shift;
            int h = height >> shift;

            buffer.position(rowStride * (crop.top >> shift) + pixelStride * (crop.left >> shift));
            for(int row = 0; row < h; row++){
                int length;
                if(pixelStride == 1 && outputSize == 1){
                    length = w;
                    buffer.get(data, channelOffest, length);
                    channelOffest += length;
                }else {
                    length = (w - 1)*pixelStride + 1;
                    buffer.get(rowData, 0, length);
                    for(int col = 0; col < w; col++){
                        data[channelOffest] = rowData[col * pixelStride];
                        channelOffest += outputSize;
                    }
                }

                if(row < h - 1){
                    buffer.position(buffer.position() + rowStride - length);
                }
            }
            Log.d(TAG, "reading data from plane finish" );
        }
        image.close();
        return data;
    }
}
