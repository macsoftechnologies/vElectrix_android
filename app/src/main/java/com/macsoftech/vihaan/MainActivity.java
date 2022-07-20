package com.macsoftech.vihaan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.model.BrandListResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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