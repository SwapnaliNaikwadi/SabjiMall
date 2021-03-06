package com.example.a.sabjimall.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a.sabjimall.Adapter.FruitAdapter;
import com.example.a.sabjimall.Adapter.VegetableAdapter;
import com.example.a.sabjimall.ClickListener;
import com.example.a.sabjimall.R;
import com.example.a.sabjimall.api.ApiClient;
import com.example.a.sabjimall.api.ApiIterface;
import com.example.a.sabjimall.models.Fruits;
import com.example.a.sabjimall.models.Vegetables;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FreshVegetablesFragment extends Fragment {

    RecyclerView prod_recycler;
    public FreshVegetablesFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_fresh_vegetables, container, false);
        prod_recycler = (RecyclerView)view.findViewById(R.id.product_recycler);


        prod_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));

        final ApiIterface apiService =
                ApiClient.getClient().create(ApiIterface.class);
        Call<List<Vegetables>> call = apiService.getVegetablesList();

        call.enqueue(new Callback<List<Vegetables>>() {
            @Override
            public void onResponse(Call<List<Vegetables>> call, Response<List<Vegetables>> response) {
                List<Vegetables> list= response.body();
                VegetableAdapter prod_adapter=new VegetableAdapter(getContext(), list, new ClickListener() {
                    @Override
                    public void onPositionClicked(int position) {

                    }
                });
                prod_recycler.setAdapter(prod_adapter);


            }

            @Override
            public void onFailure(Call<List<Vegetables>> call, Throwable t) {

            }
        });
        return  view;
    }
}



