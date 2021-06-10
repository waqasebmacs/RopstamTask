package com.buzzware.ropstamapplication.model;

public class Category {
    int categoryIV;
    String category_Title;

    public Category(int categoryIV, String category_Title) {
        this.categoryIV = categoryIV;
        this.category_Title = category_Title;
    }

    public int getCategoryIV() {
        return categoryIV;
    }

    public void setCategoryIV(int categoryIV) {
        this.categoryIV = categoryIV;
    }

    public String getCategory_Title() {
        return category_Title;
    }

    public void setCategory_Title(String category_Title) {
        this.category_Title = category_Title;
    }
}
