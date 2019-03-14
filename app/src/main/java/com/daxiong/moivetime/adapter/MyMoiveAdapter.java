package com.daxiong.moivetime.adapter;

import android.content.Context;
import android.icu.text.UnicodeSet;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daxiong.moivebaselib.http.entity.Moive250;
import com.daxiong.moivebaselib.http.entity.MovieItem;
import com.daxiong.moivebaselib.imageload.ImageLoder;
import com.daxiong.moivebaselib.util.TextUtil;
import com.daxiong.moivetime.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * author: tonydeng
 * mail : tonydeng@hxy.com
 * 2019/3/13
 */
public class MyMoiveAdapter extends PagerAdapter {
    private final static String TAG = "MyMainAdapter";
    private Moive250 listMoive;
    private Context context;

    public MyMoiveAdapter(Context context, Moive250 listMoive) {
        this.context = context;
        this.listMoive = listMoive;
    }

    @Override
    public int getCount() {

        return listMoive.getSubjects() == null ? 0 : listMoive.getSubjects().size();
    }

    public void setListMoive(Moive250 listMoive) {
        this.listMoive = listMoive;
        notifyDataSetChanged();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        //super.destroyItem(container, position, object);
        container.removeView((View) object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = View.inflate(context, R.layout.item_main_viewpager, null);
        SimpleDraweeView imageView = view.findViewById(R.id.iv_main);
        TextView tvTitle = view.findViewById(R.id.tv_main);

        Uri uri = Uri.parse(listMoive.getSubjects().get(position).getImages().getMedium());
        imageView.setImageURI(uri);
        tvTitle.setText(TextUtil.decodeUnicode(listMoive.getSubjects().get(position).getTitle()));
        container.addView(view);
        return view;
    }
}
