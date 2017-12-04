package com.example.user.qrrecoder.data.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;

/**
 * Created by USER on 2017/11/7.
 */
@Entity
public class User {
    @Id private Long id;
    @Index(unique = true)
    private int userid;
    private String username;
    private String fname;
    private String userpwd;
    private String email;
    @Generated(hash = 739195874)
    public User(Long id, int userid, String username, String fname, String userpwd,
            String email) {
        this.id = id;
        this.userid = userid;
        this.username = username;
        this.fname = fname;
        this.userpwd = userpwd;
        this.email = email;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public int getUserid() {
        return this.userid;
    }
    public void setUserid(int userid) {
        this.userid = userid;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUserpwd() {
        return this.userpwd;
    }
    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }
    public String getFname() {
        return this.fname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
  
}
