package com.example.attempt_3;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface StockApi {
    String stock_ticker = "IBM";
//search how to modify get call with arraylist data
    @GET("query?function=OVERVIEW&symbol=" + stock_ticker + "&apikey=demo")
        //PSPJXD6H5JCCNM9J")
    Call<Post> getPost();
}