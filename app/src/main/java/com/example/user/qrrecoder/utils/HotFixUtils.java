package com.example.user.qrrecoder.utils;

import com.example.user.qrrecoder.app.MyApp;
import com.example.user.qrrecoder.app.SPKey;
import com.taobao.sophix.SophixManager;

/**
 * Created by dxs on 2017/12/11.
 */

public class HotFixUtils {
    private static long TIME_SPLITE=1000*3;
    public static void checkPatch(){
        long time=SharedPrefreUtils.getInstance().getLongData(MyApp.app, SPKey.SP_HOTFIX_TIME_SPLITE);
        long timeNow=System.currentTimeMillis();
        if(timeNow-time>=TIME_SPLITE){
            SharedPrefreUtils.getInstance().putLongData(MyApp.app,SPKey.SP_HOTFIX_TIME_SPLITE,timeNow);
            SophixManager.getInstance().queryAndLoadNewPatch();
        }
    }
}
