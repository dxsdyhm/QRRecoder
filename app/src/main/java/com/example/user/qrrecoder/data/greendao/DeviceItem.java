package com.example.user.qrrecoder.data.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.ToOne;

import java.sql.Date;
import java.text.DateFormat;

/**
 * Created by USER on 2017/11/7.
 */

@Entity
public class DeviceItem {
    @Index
    private String deviceid;
    @Index
    private String userid;
    private long recordtime;
    private int serverState;//上传的状态
    @Generated(hash = 1650400776)
    public DeviceItem(String deviceid, String userid, long recordtime,
            int serverState) {
        this.deviceid = deviceid;
        this.userid = userid;
        this.recordtime = recordtime;
        this.serverState = serverState;
    }
    @Generated(hash = 1139167867)
    public DeviceItem() {
    }
    public String getUserid() {
        return this.userid;
    }
    public void setUserid(String userid) {
        this.userid = userid;
    }
    public int getServerState() {
        return this.serverState;
    }
    public void setServerState(int serverState) {
        this.serverState = serverState;
    }
    public long getRecordtime() {
        return this.recordtime;
    }
    public void setRecordtime(long recordtime) {
        this.recordtime = recordtime;
    }
    public String getDeviceid() {
        return this.deviceid;
    }
    public void setDeviceid(String deviceid) {
        this.deviceid = deviceid;
    }
}
