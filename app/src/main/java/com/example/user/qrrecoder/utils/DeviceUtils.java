package com.example.user.qrrecoder.utils;

import android.text.TextUtils;

/**
 * Created by USER on 2017/11/10.
 */

public class DeviceUtils {
    public static boolean isLegal(String result){
        return !TextUtils.isEmpty(result);
    }
}
