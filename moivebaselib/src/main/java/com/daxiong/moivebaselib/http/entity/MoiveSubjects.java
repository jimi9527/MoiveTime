package com.daxiong.moivebaselib.http.entity;

import java.io.Serializable;
import java.util.List;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/13
 */
public class MoiveSubjects implements Serializable {
      private Rating rating;
      // 电影类型
      private List<String> genres;
      private String title;
      // 演员列表
     private List<Casts> casts;
     private long collect_count;
     private String original_title;
     private String subtype;
     private List<Directors> directors;
     private String year;
     // 海报
     private ImageType images;
     private String alt;
     private long id;

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Casts> getCasts() {
        return casts;
    }

    public void setCasts(List<Casts> casts) {
        this.casts = casts;
    }

    public long getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(long collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public List<Directors> getDirectors() {
        return directors;
    }

    public void setDirectors(List<Directors> directors) {
        this.directors = directors;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImageType getImages() {
        return images;
    }

    public void setImages(ImageType images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public class Rating{
        private int max;
        private float average;
        private String stars;
        private int min;
    }

    public class Casts{
        private String alt;
        private ImageType avatars;
        private String name;
        private long id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public ImageType getAvatars() {
            return avatars;
        }

        public void setAvatars(ImageType avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

    public class Directors{
        private String alt;
        private ImageType avatars;
        private String name;
        private long id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public ImageType getAvatars() {
            return avatars;
        }

        public void setAvatars(ImageType avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }
    }

}
