package com.daxiong.moivebaselib.http.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 电影
 *
 * @Author perbo
 * @Email perbo@hyx.com
 * @date 2017/11/28 11:05
 */
public class MovieListEntity implements Serializable {
    private List<MovieItem> films;
    private int total;//数据总数

    public List<MovieItem> getFilms() {
        return films;
    }

    public void setFilms(List<MovieItem> films) {
        this.films = films;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
