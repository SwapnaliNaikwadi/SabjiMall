package com.example.a.sabjimall.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.a.sabjimall.models.AreaPinPojo;
import com.example.a.sabjimall.R;

public class MainActivity extends AppCompatActivity {

    Spinner area;

    Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setTitle("Area Selection");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        area = (Spinner) findViewById(R.id.area_spinner);

        proceed=(Button)findViewById(R.id.proceed);



        ArrayAdapter<AreaPinPojo> adapter =
                new ArrayAdapter<AreaPinPojo>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item, AreaPinPojo.getAreaPin());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        area.setAdapter(adapter);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }





}