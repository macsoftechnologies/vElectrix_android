package com.macsoftech.vihaan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
//        RestApi.getInstance().getService().brandList().enqueue(new Callback<BrandListResponse>() {
//            @Override
//            public void onResponse(Call<BrandListResponse> call, Response<BrandListResponse> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<BrandListResponse> call, Throwable t) {
//
//            }
//        });
    }
}