package com.example.anxia.newsapplication.net;

import com.example.anxia.newsapplication.bean.Constants;
import com.example.anxia.newsapplication.bean.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtil {
    public static void getNews(Callback<HttpResult<List<News>>> callback){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService=retrofit.create(ApiService.class);

        Call<HttpResult<List<News>>> call=apiService.getNews();
        call.enqueue(callback);
    }
}
