package com.example.a.sabjimall.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.a.sabjimall.Adapter.FruitAdapter;
import com.example.a.sabjimall.ClickListener;
import com.example.a.sabjimall.R;
import com.example.a.sabjimall.View.ViewFruitsActivity;
import com.example.a.sabjimall.api.ApiClient;
import com.example.a.sabjimall.api.ApiIterface;
import com.example.a.sabjimall.models.Fruits;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FreshFruitsFragment extends Fragment  {

    RecyclerView prod_recycler;
    ProgressBar progressBar;
    SearchView searchView;

    public FreshFruitsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fresh_fruits, container, false);
        prod_recycler = (RecyclerView)view.findViewById(R.id.product_recycler);
        progressBar=(ProgressBar)view.findViewById(R.id.pbHeaderProgress);


        progressBar.setVisibility(View.VISIBLE);

        prod_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ApiIterface apiService =
                ApiClient.getClient().create(ApiIterface.class);
        Call<List<Fruits>> call = apiService.getList();

        call.enqueue(new Callback<List<Fruits>>() {
            @Override
            public void onResponse(Call<List<Fruits>> call, Response<List<Fruits>> response) {
                List<Fruits> list= response.body();

                FruitAdapter prod_adapter=new FruitAdapter(getContext(), list, new ClickListener() {
                    @Override
                    public void onPositionClicked(int position) {

                    }
                });
                prod_recycler.setAdapter(prod_adapter);

                progressBar.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<List<Fruits>> call, Throwable t) {

            }
        });
        return  view;
    }





}
