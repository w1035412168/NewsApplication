package com.example.anxia.newsapplication.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.anxia.newsapplication.R;
import com.example.anxia.newsapplication.bean.News;

import java.util.List;

public class MyRecyclerViewAdapter extends BaseQuickAdapter<News,BaseViewHolder> {


    public MyRecyclerViewAdapter(int layoutResId, @Nullable List<News> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, News item) {
        helper.setText(R.id.tv_title,item.getTitle());
        helper.setText(R.id.tv_content,item.getContent());
        Glide.with(mContext).load(item.getImageUrl()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher)
                .into((ImageView)helper.getView(R.id.iv_news));


    }
}
