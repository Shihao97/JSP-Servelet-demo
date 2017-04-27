package com.test.web.entity;

/**
 * Created by 石昊 on 2017/4/8.
 */
public class User {
    //主键ID
    private int id;
    //用户名
    private String username;
    //密码
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
