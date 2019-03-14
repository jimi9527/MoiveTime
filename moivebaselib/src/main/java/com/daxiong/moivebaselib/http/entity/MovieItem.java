package com.daxiong.moivebaselib.http.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 电影列表
 *
 * @Author perbo
 * @Email perbo@hyx.com
 * @date 17/12/7 09:44
 */
public class MovieItem implements Serializable {
    private long filmId;//电影Id
    private String name;//电影名
    private String poster;//海报
    private List<Actor> actors;//演员信息
    private String director;//导演
    private String category;//电影类型
    private long premiereAt;//上映时间
    private int timeType; //标识模糊上映时间的年月日展示位数 0: 未设上映时间 1:指定到 年 2:指定到 年-月 3:指定到 年-月-日
    private int runtime;//影片时长
    private String grade;//评分
    private boolean isPresale;//是否支持售票
    private MovieType item;//电影类型
    private String nation;//国家
    private String language;//语言

    public long getFilmId() {
        return filmId;
    }

    public void setFilmId(long filmId) {
        this.filmId = filmId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getPremiereAt() {
        return premiereAt;
    }

    public void setPremiereAt(long premiereAt) {
        this.premiereAt = premiereAt;
    }

    public int getTimeType() {
        return timeType;
    }

    public void setTimeType(int timeType) {
        this.timeType = timeType;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    public boolean isPresale() {
        return isPresale;
    }

    public void setPresale(boolean presale) {
        this.isPresale = presale;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public MovieType getItem() {
        return item;
    }

    public void setItem(MovieType item) {
        this.item = item;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}
