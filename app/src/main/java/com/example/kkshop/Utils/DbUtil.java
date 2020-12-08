package com.example.kkshop.Utils;

import android.graphics.Bitmap;

import com.example.kkshop.Po.User;

import java.io.ByteArrayOutputStream;

/**
 *
 * 数据库的工具类
 *
 */
public class DbUtil {

    private static final String TAG = "DbUtil";


    /**
     * 把图片转成byte[]
     * @param bitmap
     * @return
     */
    public byte[] img(Bitmap bitmap){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        return baos.toByteArray();
    }


}




