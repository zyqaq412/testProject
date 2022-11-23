package com.hzy.pojo;

/**
 * @title: User
 * @Author zxwyhzy
 * @Date: 2022/11/22 12:21
 * @Version 1.0
 */
public class User {
    private Integer username;
    private String password;

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Integer getUsername() {
        return username;
    }

    public void setUsername(Integer username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username=" + username +
                ", password='" + password + '\'' +
                ", level=" + level +
                '}';
    }
}
