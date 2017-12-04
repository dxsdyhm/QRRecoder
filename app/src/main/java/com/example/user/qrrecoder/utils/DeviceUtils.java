package com.example.user.qrrecoder.utils;

import android.text.TextUtils;
import android.util.Log;

import com.hdl.elog.ELog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by USER on 2017/11/10.
 */

public class DeviceUtils {
    private final static String DEVICEURL="http://yoosee.co/\\?D=([^(&)]*)";
    private final static String DEVICEINFO_SPLITE="-";

    public static boolean isLegal(String result){
        return getDeviceinfo(result)!=null;
    }

    public static String getDeviceinfo(String result){
        if(!TextUtils.isEmpty(result)){
            Pattern mPattern = Pattern.compile(DEVICEURL);
            Matcher mMatcher = mPattern.matcher(result);
            while (mMatcher.find()) {
                return mMatcher.group(1);
            }
        }
        return null;
    }

    public static String[] getDeviceInfoFromeUrl(String deviceInfo)throws IllegalArgumentException{
        if(TextUtils.isEmpty(deviceInfo)||!deviceInfo.contains(DEVICEINFO_SPLITE)){
            throw new IllegalArgumentException("deviceInfo "+deviceInfo+" is not illegal");
        }
        return deviceInfo.split(DEVICEINFO_SPLITE);
    }
}
