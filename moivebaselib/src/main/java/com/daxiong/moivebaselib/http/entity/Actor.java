package com.daxiong.moivebaselib.http.entity;

import java.io.Serializable;

/**
 * 演员信息
 *
 * @Author perbo
 * @Email perbo@hyx.com
 * @date 17/12/7 09:48
 */
public class Actor implements Serializable {
    private String name;//姓名
    private String role;//角色
    private String avatarAddress;//头像地址

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }
}
