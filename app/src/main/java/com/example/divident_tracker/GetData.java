package com.example.divident_tracker;

import java.io.IOException;
import java.lang.reflect.Array;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GetData {
    private ArrayList<String> stock_div = new ArrayList<>();
    String stock_ticker_string;
    String div_data = "Initial";


    ArrayList error;
        public ArrayList ApiCall(ArrayList stock_ticker, int num){


            String apiKey = "demo";
            String function = "OVERVIEW";

//            for(int j = 0; j<num; j ++) {
//                stock_ticker_string = (String.valueOf(stock_ticker.get(j)));
//
////                Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.alphavantage.co").addConverterFactory(GsonConverterFactory.create()).build();
////                StockApi stockApi = retrofit.create(StockApi.class);
////                Call<Post> call = stockApi.getPost(function, stock_ticker_string, apiKey);
//
//               //stock_div.add(j, "Within for " + div_data);
//                int numJ = j;
//                int finalJ = j;
//                call.enqueue(new Callback<Post>() {
//                    @Override
//                    public void onResponse(Call<Post> call, Response<Post> response) {
//                        if (!response.isSuccessful()) {
//                            //div_data = MessageFormat.format("Code: {0}", response.code());
////                            div_data = "It didnt work";
////                            stock_div.add(numJ,div_data);
//                        }
//                        stock_div.add(finalJ, "Within call " + div_data);
////                        Post post = response.body();
////
////                        String content = "";
////
////                        double div = 0.0;
////                        double sum = 0.0;
////
////                        if (post != null) {
////                            div = Double.parseDouble(post.getDividendPerShare());
////                        }
////
////                        content = "$" + "It worked!" ; // Working\
////                        div_data = content;
////                        stock_div.add(numJ,div_data);
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<Post> call, Throwable t) {
//                        //div_data = t.getMessage();
////                        div_data = "It didnt work";
////                        stock_div.add(numJ,div_data);
//                    }
//                });
//            }
            //For demo only
            final int random = new Random().nextInt(10);
            final int random2 = new Random().nextInt(5);
            if(stock_div.size() == 0) {
                for (int i = 0; i < num; i++) { //used for testing
                    stock_div.add(i, "$"+ String.valueOf(random) + ".0" + String.valueOf(random2));
                }
            }
        return stock_div;
//        String urlTicker = "";
//        Double quant = 0.0;
//        if(i==0){
//            urlTicker = String.valueOf(stock_ticker.get(position));
//            quant =Double.parseDouble(String.valueOf(stock_quantity.get(position)));
//            i++;
//        }else{
//             urlTicker = String.valueOf(stock_ticker.get(position+1));
//            quant =Double.parseDouble(String.valueOf(stock_quantity.get(position+1)));
//        }
//
//      //  String urlTicker = String.valueOf(stock_ticker.get(position));
//        //String apiKey = "PSPJXD6H5JCCNM9J";
//        String apiKey = "demo";
//        String function = "OVERVIEW";
//        //Double quant = Double.parseDouble(String.valueOf(stock_quantity.get(position)));
//
//
//        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://www.alphavantage.co").addConverterFactory(GsonConverterFactory.create()).build();
//        StockApi stockApi = retrofit.create(StockApi.class);
//        Call<Post> call = stockApi.getPost(function,urlTicker,apiKey);
//        //noinspection NullableProblems
//        call.enqueue(new Callback<Post>() {
//            @Override
//            public void onResponse(Call<Post> call, Response<Post> response) {
//                if (!response.isSuccessful()){
//                    annualDiv.setText(MessageFormat.format("Code: {0}", response.code()));
//                    return;
//                }
//                Post post = response.body();
//
//                String content = "";
//
//                double div = 0.0;
//                double sum = 0.0;
//
//
//                if (post != null) {
//                    div = Double.parseDouble(post.getDividendPerShare());
//                }
//              Double quant = Double.parseDouble(String.valueOf(stock_quantity.get(position)));
//                sum = div*quant;
//                content = "$" + stock_quantity + " Quant: " + quant; //Tester
//                //content = "$" + div ; // Working
//                annualDiv.setText(content);
//
//            }
//            @Override
//            public void onFailure(Call<Post> call, Throwable t) {
//                annualDiv.setText(t.getMessage());
//            }
//        });
//
    }
}
