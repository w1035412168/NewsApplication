package com.example.anxia.newsapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.anxia.newsapplication.R;
import com.example.anxia.newsapplication.adapter.MyRecyclerViewAdapter;
import com.example.anxia.newsapplication.bean.News;
import com.example.anxia.newsapplication.net.HttpResult;
import com.example.anxia.newsapplication.net.RetrofitUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<News> newsList;
    private View view;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.fragment_news, container, false);
        initView();
        init();
        return view;
    }

    private void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new MyRecyclerViewAdapter(R.layout.recycler_item,newsList));
        RetrofitUtil.getNews(new Callback<HttpResult<List<News>>>() {
            @Override
            public void onResponse(Call<HttpResult<List<News>>> call, Response<HttpResult<List
                                <News>>> response) {
                newsList=response.body().getData();
            }

            @Override
            public void onFailure(Call<HttpResult<List<News>>> call, Throwable t) {

            }
        });
    }

    private void initView() {
        recyclerView=view.findViewById(R.id.recycler_view);

    }

}
