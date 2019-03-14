package com.daxiong.moivebaselib.http.entity;

import java.io.Serializable;

/**
 * 电影类型
 *
 * @Author perbo
 * @Email perbo@hyx.com
 * @date 17/12/7 09:50
 */
public class MovieType implements Serializable {
    private int type;//类型
    private String name;//名字

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
