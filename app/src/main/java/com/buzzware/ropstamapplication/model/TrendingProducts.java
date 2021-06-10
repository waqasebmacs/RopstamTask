package com.buzzware.ropstamapplication.model;

public class TrendingProducts {
    int trending_IV;
    String  trending_title;

    public TrendingProducts(int trending_IV, String trending_title) {
        this.trending_IV = trending_IV;
        this.trending_title = trending_title;
    }

    public int getTrending_IV() {
        return trending_IV;
    }

    public void setTrending_IV(int trending_IV) {
        this.trending_IV = trending_IV;
    }

    public String getTrending_title() {
        return trending_title;
    }

    public void setTrending_title(String trending_title) {
        this.trending_title = trending_title;
    }
}
