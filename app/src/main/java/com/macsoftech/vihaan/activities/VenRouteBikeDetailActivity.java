package com.macsoftech.vihaan.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;

import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.fragment.VenrouteBikeDetailFragment;

public class VenRouteBikeDetailActivity extends BaseActivity {

    private String vehicleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venroute_bike_detail);
        getSupportActionBar().setTitle("Detail");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().hide();
        Intent intent = getIntent();

        vehicleId = intent.getStringExtra("vehicleId");


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

