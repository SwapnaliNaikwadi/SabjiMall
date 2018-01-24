package com.example.a.sabjimall.api;

import com.example.a.sabjimall.models.Fruits;
import com.example.a.sabjimall.models.TodaysOffer;
import com.example.a.sabjimall.models.Vegetables;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiIterface {

    @GET("1")
    Call<List<Fruits>> getList();

    @GET("2")
    Call<List<Vegetables>> getVegetablesList();

    @GET("4")
    Call<List<TodaysOffer>> getTodaysOfferList();

    @GET("1")
    Call<List<Fruits>> getItem(String pcode);
}





