package com.example.divident_tracker;

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
