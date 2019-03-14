package com.daxiong.moivebaselib.base;

import com.daxiong.moivebaselib.http.BaseMoiveObserver;
import com.daxiong.moivebaselib.http.BaseObserver;
import com.daxiong.moivebaselib.http.MoiveService;
import com.daxiong.moivebaselib.http.RetofitManager;
import com.daxiong.moivebaselib.http.entity.BaseEntity;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.PUT;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/7
 */
public class BasePresenter<V extends BaseView>{
    public static final String TAG = "BasePresenter";
    private CompositeDisposable compositeDisposable;
    private V mBaseView;
    protected MoiveService moiveService = RetofitManager.getInstance().getMoiveService();

    public void attachView(V view){
        mBaseView = view;
    }
    public void detachView(){
        mBaseView = null;
    }

    public V getmBaseView(){
        return mBaseView;
    }

    /**
     * 统一管理
     */
    public void addComposite(Observable<?> observable, BaseMoiveObserver baseObserver){
        if(compositeDisposable == null){
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(observable.
                subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(baseObserver));
    }

    public void cancle(){
        if(compositeDisposable != null){
            compositeDisposable.clear();
        }
    }
}
