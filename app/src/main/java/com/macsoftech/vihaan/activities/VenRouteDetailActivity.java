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
import com.macsoftech.vihaan.fragment.VenrouteBannerFragment;

public class VenRouteDetailActivity extends AppCompatActivity {

    private String brandLogo;
    private String brandName;
    ImageView imgBrandLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_venroute_detail);
        getSupportActionBar().hide();

       Intent intent =  getIntent();

        brandLogo = intent.getStringExtra("brandLogo");
        brandName = intent.getStringExtra("brandName");

        imgBrandLogo =  (ImageView) findViewById(R.id.bannerLogo);

        Glide.with(this)
                .load(RestApi.BASE_URL+brandLogo)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .fitCenter()
                .placeholder(R.drawable.nav_profile)
                .error(R.drawable.nav_profile)
                .into(imgBrandLogo);


        VenrouteBannerDetailFragment venrouteBannerDetailFragment = new VenrouteBannerDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("brandName", brandName);
        venrouteBannerDetailFragment.setArguments(bundle);

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment,venrouteBannerDetailFragment);
        fragmentTransaction.commit();

    }

}

