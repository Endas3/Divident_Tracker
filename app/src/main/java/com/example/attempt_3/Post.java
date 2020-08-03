package com.example.attempt_3;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String Symbol;
    private String DividendPerShare;

    @SerializedName("body")
    private String text;

    public String getSymbol() {
        return Symbol;
    }
    public String getDividendPerShare() {
        return DividendPerShare;
    }
}
