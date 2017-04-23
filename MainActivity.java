package com.tariposio.team06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tariposio.team06.HRservices.HRservices;
import com.tariposio.team06.HRservices.PositionServices.PositionServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private HRservices service;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://10.51.4.17/TSP57/PCK")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(HRservices.class);

        service.getPositionData().enqueue(new Callback<PositionServices>() {
            @Override
            public void onResponse(Call<PositionServices> call, Response<PositionServices> response) {
                Log.d("Response",response.message());
            }

            @Override
            public void onFailure(Call<PositionServices> call, Throwable t) {
                Log.d("Response",t.getMessage());
            }
        });
    }
}
