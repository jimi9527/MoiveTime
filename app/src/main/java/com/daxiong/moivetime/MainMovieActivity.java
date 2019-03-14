package com.daxiong.moivetime;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import com.daxiong.moivebaselib.base.MvpBaseActivity;
import com.daxiong.moivebaselib.http.entity.Moive250;
import com.daxiong.moivetime.adapter.MyMoiveAdapter;
import com.daxiong.moivetime.contarct.Moive250Contarct;
import com.daxiong.moivetime.presenter.MoivePresenter;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/13
 */
public class MainMovieActivity extends MvpBaseActivity<Moive250Contarct.view, MoivePresenter> implements Moive250Contarct.view {
    private static final String TAG = "MainMovieActivity";
    private ViewPager mViewPager;
    private TextView mIconMenu, mName;
    private MyMoiveAdapter mMyMoiveAdapter;
    private Moive250 listMoive;

    @Override
    public int RootlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();

        listMoive = new Moive250();
        mIconMenu = findViewById(R.id.icon_menu);
        mName = findViewById(R.id.movie_type);
        mViewPager = findViewById(R.id.main_vp);
        mMyMoiveAdapter = new MyMoiveAdapter(this, listMoive);

        mViewPager.setPageMargin(20);
        mViewPager.setAdapter(mMyMoiveAdapter);

        mIconMenu.setTypeface(iconfont);

        getPresenter().getFilmsList(0, 10);

        mViewPager.addOnPageChangeListener(new MyOnPageChangeListener());

    }

    class MyOnPageChangeListener implements ViewPager.OnPageChangeListener{
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            Log.d(TAG, "onPageSelected");
            Log.d(TAG, "i:" + i);
            if(listMoive.getSubjects() != null){
                mName.setText("");
                mName.setText(listMoive.getSubjects().get(i).getTitle());
            }
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    }

    @Override
    public MoivePresenter createPresenter() {
        return new MoivePresenter();
    }

    @Override
    public void showFilms(Moive250 moive250) {
        Log.d(TAG, "showFilms");
        if(moive250 != null){
            listMoive = moive250;
            mMyMoiveAdapter.setListMoive(moive250);
            if(moive250.getSubjects() != null && moive250.getSubjects().size() > 0){
                mName.setText(listMoive.getSubjects().get(0).getTitle());
            }
        }
    }

    @Override
    public void showError(String msg) {
        Log.d(TAG, "showError:" + msg);
    }
}
