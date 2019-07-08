package com.example.geniusplazacodingtest.models;

//This is the model for actual JSON response

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

//This is the format in which we will receive a JSON response.

public class JsonResponse {

    @SerializedName("page")
    private String page;

    @SerializedName("per_page")
    private String per_page;

    @SerializedName("total")
    private String total;

    @SerializedName("total_pages")
    private String total_pages;

    @SerializedName("data")
    private ArrayList<User> data;

    public JsonResponse(String page, String per_page, String total, String total_pages, ArrayList<User> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPer_page() {
        return per_page;
    }

    public void setPer_page(String per_page) {
        this.per_page = per_page;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(String total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<User> getData() {
        return data;
    }

    public void setData(ArrayList<User> data) {
        this.data = data;
    }
}
