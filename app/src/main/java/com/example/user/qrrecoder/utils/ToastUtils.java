package com.example.user.qrrecoder.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

import es.dmoral.toasty.Toasty;

/**
 * Created by dxs on 2017/12/4.
 */

public class ToastUtils {
    public static void ShowSuccess(Context context, String text, int time, boolean withIcon){
        Toasty.success(context, text, time, withIcon).show();
    }

    public static void ShowSuccess(Context context, String text){
        ShowSuccess(context, text, 1500, true);
    }

    public static void ShowError(Context context, String text, int time,boolean withIcon){
        Toasty.error(context, text, time, withIcon).show();
    }

    public static void ShowNormoal(Context context, String text, int time,Drawable Icon){
        Toasty.normal(context, text, time, Icon).show();
    }
}
