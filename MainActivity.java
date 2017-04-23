package com.tariposio.team06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.tariposio.team06.HRservices.HRservices;
import com.tariposio.team06.HRservices.PositionServices;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
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

        // Define the interceptor, add authentication headers
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                Request newRequest = chain.request().newBuilder().addHeader("User-Agent", "Retrofit-Sample-App").build();
                return chain.proceed(newRequest);
            }
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.51.4.17/TSP57/PCK/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
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
