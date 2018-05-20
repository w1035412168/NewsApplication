package com.example.anxia.newsapplication.net;

import com.example.anxia.newsapplication.bean.News;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("getnews.php")
    Call<HttpResult<List<News>>> getNews();
}
