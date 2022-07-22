package com.macsoftech.vihaan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.fragment.VenrouteBannerDetailFragment;
import com.macsoftech.vihaan.fragment.VenrouteBikeDetailFragment;

public class VenRouteBikeDetailActivity extends AppCompatActivity {

    private String vehicleId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_venroute_bike_detail);
        getSupportActionBar().hide();

        Intent intent = getIntent();

        vehicleId = intent.getStringExtra("vehicleId");


        VenrouteBikeDetailFragment venrouteBannerDetailFragment = new VenrouteBikeDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("vehicleId", vehicleId);
        venrouteBannerDetailFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, venrouteBannerDetailFragment);
        fragmentTransaction.commit();

    }

}

