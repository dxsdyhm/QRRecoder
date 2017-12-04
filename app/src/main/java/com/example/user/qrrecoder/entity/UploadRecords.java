package com.example.user.qrrecoder.entity;

import android.util.Log;

import com.example.user.qrrecoder.data.greendao.DeviceItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

/**
 * Created by dxs on 2017/12/1.
 */

public class UploadRecords {
    private String userId;
    private List<DeviceItem> deviceItems;

    public UploadRecords() {
    }

    public UploadRecords(String userId, List<DeviceItem> deviceItems) {
        this.userId = userId;
        this.deviceItems = deviceItems;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<DeviceItem> getDeviceItems() {
        return deviceItems;
    }

    public void setDeviceItems(List<DeviceItem> deviceItems) {
        this.deviceItems = deviceItems;
    }

    public String getJsonString(){
        Log.e("dxsTest",deviceItems.get(0).toString());
//        Gson gson=new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        Gson gson=new Gson();
        String json=gson.toJson(deviceItems);
        Log.e("dxsTest","json:"+json);
        return json;
    }
}
