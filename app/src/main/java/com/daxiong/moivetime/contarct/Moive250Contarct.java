package com.daxiong.moivetime.contarct;

import com.daxiong.moivebaselib.base.BaseView;
import com.daxiong.moivebaselib.http.entity.Moive250;

import java.util.List;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/13
 */
public interface Moive250Contarct {

    interface view extends BaseView{
        void showFilms(Moive250 moive250);
        void showError(String msg);
    }

    interface presenter{
        void getFilmsList(int start, int count);
    }
}
