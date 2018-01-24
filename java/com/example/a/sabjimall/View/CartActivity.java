package com.example.a.sabjimall.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a.sabjimall.Adapter.CartAdapter;
import com.example.a.sabjimall.Adapter.FruitAdapter;
import com.example.a.sabjimall.CartDb;
import com.example.a.sabjimall.ClickListener;
import com.example.a.sabjimall.R;
import com.example.a.sabjimall.api.ApiClient;
import com.example.a.sabjimall.api.ApiIterface;
import com.example.a.sabjimall.models.Fruit;
import com.example.a.sabjimall.models.Fruits;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity {
    RecyclerView prod_recycler;
    CartDb db;
    CartAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        db=new CartDb(this);
        prod_recycler = (RecyclerView)findViewById(R.id.cart);

        prod_recycler.setLayoutManager(new LinearLayoutManager(this));
        prod_recycler.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        List<Fruit> fruits= db.getAllContacts();

        CartAdapter adapter=new CartAdapter(this, fruits, new ClickListener() {
            @Override
            public void onPositionClicked(int position) {

            }
        });


       // final ArrayList<Fruits> fruits = new ArrayList<>(db.);

       // adapter = new CartAdapter(this, fruits);

        prod_recycler.setAdapter(adapter);




    }
}
