package com.macsoftech.vihaan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.fragment.VenrouteBikeDetailFragment;
import com.macsoftech.vihaan.model.BrandResponse;

public class VenRouteBikeDetailActivity extends BaseActivity {

    private String vehicleId;
    ImageView bannerLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venroute_bike_detail);
        bannerLogo = findViewById(R.id.bannerLogo);
         getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().hide();
        Intent intent = getIntent();

        vehicleId = intent.getStringExtra("vehicleId");
        String brandLogo = intent.getStringExtra("brandLogo");
        BrandResponse data = getIntent().getParcelableExtra("data");
        //brandLogo
        Glide.with(this)
                .load(RestApi.BASE_URL + brandLogo)
                .into(bannerLogo);

        VenrouteBikeDetailFragment venrouteBannerDetailFragment = new VenrouteBikeDetailFragment();
        Bundle bundle = new Bundle();
//        bundle.putString("vehicleId", vehicleId);
//        bundle.putString("data", intent.getParcelableExtra("data"));
        venrouteBannerDetailFragment.setArguments(getIntent().getExtras());

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, venrouteBannerDetailFragment);
        fragmentTransaction.commit();

    }

}

