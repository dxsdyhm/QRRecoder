package com.example.user.qrrecoder.data.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.ToOne;

/**
 * Created by USER on 2017/11/7.
 */

@Entity
public class DeviceItem {
    @Index
    private String name;
    @Index
    private String userid;
    private int serverState;//上传的状态
    @Generated(hash = 174553394)
    public DeviceItem(String name, String userid, int serverState) {
        this.name = name;
        this.userid = userid;
        this.serverState = serverState;
    }
    @Generated(hash = 1139167867)
    public DeviceItem() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
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
}
