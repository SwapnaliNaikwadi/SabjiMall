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

import com.example.a.sabjimall.Adapter.TodaysOfferAdapter;
import com.example.a.sabjimall.Adapter.VegetableAdapter;
import com.example.a.sabjimall.ClickListener;
import com.example.a.sabjimall.R;
import com.example.a.sabjimall.api.ApiClient;
import com.example.a.sabjimall.api.ApiIterface;
import com.example.a.sabjimall.models.TodaysOffer;
import com.example.a.sabjimall.models.Vegetables;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class TodaysOfferFragment extends Fragment {
    RecyclerView prod_recycler;
    public TodaysOfferFragment() {
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
        View view=inflater.inflate(R.layout.fragment_todays_offer, container, false);
        prod_recycler = (RecyclerView)view.findViewById(R.id.product_recycler);


        prod_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));


        return  view;
    }

}
