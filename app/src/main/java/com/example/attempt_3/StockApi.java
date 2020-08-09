package com.example.attempt_3;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StockApi {
    @GET("/query")
    Call<Post> getPost(
//            @Query("apikey") String apiKey,
            @Query("function") String function,
            @Query("symbol") String symbol,//);
            @Query("apikey") String apiKey);
}