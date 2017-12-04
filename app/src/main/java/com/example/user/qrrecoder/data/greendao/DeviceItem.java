package com.example.user.qrrecoder.data.greendao;

import com.google.gson.annotations.Expose;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Transient;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.DateFormat;

/**
 * Created by USER on 2017/11/7.
 */

@Entity
public class DeviceItem{
    @Id private Long id;
    @Expose
    @Index(unique = true)
    @NotNull
    private int fdeviceid;
    @Expose
    @Index
    private int fid;
    @Expose
    @NotNull
    private String fdeviceuuid;
    @Expose
    private long fscantime;
    @Expose(serialize = false)
    private int serverState;//上传的状态
    @Expose
    private String faccount;
    @Expose
    private String fcreate;
    @Expose
    private long ftime;
    @Expose
    private String fstatus;
    @Expose
    private String fdes;//描述
    @Generated(hash = 306625901)
    public DeviceItem(Long id, int fdeviceid, int fid, @NotNull String fdeviceuuid,
            long fscantime, int serverState, String faccount, String fcreate,
            long ftime, String fstatus, String fdes) {
        this.id = id;
        this.fdeviceid = fdeviceid;
        this.fid = fid;
        this.fdeviceuuid = fdeviceuuid;
        this.fscantime = fscantime;
        this.serverState = serverState;
        this.faccount = faccount;
        this.fcreate = fcreate;
        this.ftime = ftime;
        this.fstatus = fstatus;
        this.fdes = fdes;
    }
    @Generated(hash = 1139167867)
    public DeviceItem() {
    }
    public int getFdeviceid() {
        return this.fdeviceid;
    }
    public void setFdeviceid(int fdeviceid) {
        this.fdeviceid = fdeviceid;
    }
    public int getFid() {
        return this.fid;
    }
    public void setFid(int fid) {
        this.fid = fid;
    }
    public String getFdeviceuuid() {
        return this.fdeviceuuid;
    }
    public void setFdeviceuuid(String fdeviceuuid) {
        this.fdeviceuuid = fdeviceuuid;
    }
    public long getFscantime() {
        return this.fscantime;
    }
    public void setFscantime(long fscantime) {
        this.fscantime = fscantime;
    }

    public String getFaccount() {
        return this.faccount;
    }
    public void setFaccount(String faccount) {
        this.faccount = faccount;
    }
    public String getFcreate() {
        return this.fcreate;
    }
    public void setFcreate(String fcreate) {
        this.fcreate = fcreate;
    }
    public long getFtime() {
        return this.ftime;
    }
    public void setFtime(long ftime) {
        this.ftime = ftime;
    }
    public String getFstatus() {
        return this.fstatus;
    }
    public void setFstatus(String fstatus) {
        this.fstatus = fstatus;
    }
    public String getFdes() {
        return this.fdes;
    }
    public void setFdes(String fdes) {
        this.fdes = fdes;
    }

    @Override
    public String toString() {
        return "DeviceItem{" +
                "fdeviceid=" + fdeviceid +
                ", fid=" + fid +
                ", fdeviceuuid='" + fdeviceuuid + '\'' +
                ", fscantime=" + fscantime +
                ", serverState=" + serverState +
                ", faccount='" + faccount + '\'' +
                ", fcreate='" + fcreate + '\'' +
                ", ftime=" + ftime +
                ", fstatus='" + fstatus + '\'' +
                ", fdes='" + fdes + '\'' +
                '}';
    }

    public int getServerState() {
        return this.serverState;
    }
    public void setServerState(int serverState) {
        this.serverState = serverState;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
