package com.daxiong.moivebaselib.http.entity;

import java.io.Serializable;
import java.util.List;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/13
 */
public class Moive250 implements Serializable {
    private int count;
    private int start;
    private int total;
    private List<MoiveSubjects> subjects;
    private String title;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<MoiveSubjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<MoiveSubjects> subjects) {
        this.subjects = subjects;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

