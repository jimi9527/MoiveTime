package com.daxiong.moivebaselib.http;

import com.daxiong.moivebaselib.http.entity.BaseEntity;
import com.daxiong.moivebaselib.http.entity.BaseToday;
import com.daxiong.moivebaselib.http.entity.Moive250;
import com.daxiong.moivebaselib.http.entity.MovieListEntity;
import com.daxiong.moivebaselib.http.entity.Today;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/2/18
 */
public interface MoiveService {

    @GET(".")
    Observable<BaseEntity<MovieListEntity>> getHotList(@Query("cityId") int cityId,
                                                       @Query("type") int type,
                                                     @Query("pageNum") int pageNum,
                                                     @Query("pageSize") int pageSize);

    @GET("/japi/toh")
    Observable<BaseToday<Today>> getDay(@Query("key") String key,
                                        @Query("v") String v,
                                        @Query("month") int month,
                                        @Query("day") int day);


    @GET("v2/movie/top250")
    Observable<Moive250> getFilms(@Query("start") int start,
                                  @Query("count") int count);
}
