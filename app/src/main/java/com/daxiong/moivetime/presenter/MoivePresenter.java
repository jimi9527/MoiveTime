package com.daxiong.moivetime.presenter;

import com.daxiong.moivebaselib.base.BasePresenter;
import com.daxiong.moivebaselib.http.BaseMoiveObserver;
import com.daxiong.moivebaselib.http.BaseObserver;
import com.daxiong.moivebaselib.http.entity.Moive250;
import com.daxiong.moivetime.contarct.Moive250Contarct;

import java.util.List;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/13
 */
public class MoivePresenter extends BasePresenter<Moive250Contarct.view> implements Moive250Contarct.presenter {


    // 获取豆瓣top250
    @Override
    public void getFilmsList(int start, int count) {
        addComposite(moiveService.getFilms(start, count), new BaseMoiveObserver<Moive250>(){

            @Override
            public void onSuccess(Moive250 moive250s) {
                   getmBaseView().showFilms(moive250s);
            }

            @Override
            public void onFail(String error) {
                    getmBaseView().showError(error);
            }
        });
    }
}
