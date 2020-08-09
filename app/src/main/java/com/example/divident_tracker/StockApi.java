package com.example.divident_tracker;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StockApi {
    @GET("/query")
    Call<Post> getPost(
//            @Query("apikey") String apiKey,
            @Query("function") String function,
            @Query("symbol") String symbol,//);
            @Query("apikey") String apiKey);
}