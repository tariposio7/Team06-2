package com.tariposio.team06;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.tariposio.team06.HRservices.HRservices;
import com.tariposio.team06.HRservices.ProfileServices.ProfileServices;

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
                .baseUrl("https://10.51.4.17/TSP57/PCK/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(HRservices.class);

        service.getResumedata().enqueue(new Callback<ProfileServices>() {
            @Override
            public void onResponse(Call<ProfileServices> call, Response<ProfileServices> response) {
                Log.d("Response","Success");
                Log.d("Response",response.message());
                Toast.makeText(MainActivity.this,
                        "Your Message", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<ProfileServices> call, Throwable t) {
                Log.d("Response","Fail");
                Log.d("Response",t.getMessage());
            }
        });
    }
}
