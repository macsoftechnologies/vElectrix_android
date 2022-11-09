package com.macsoftech.vihaan.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.fragment.app.FragmentTransaction;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.api.RestApi;
import com.macsoftech.vihaan.fragment.VenrouteBannerDetailFragment;

public class VenRouteDetailActivity extends BaseActivity {

    private String brandLogo;
    private String brandName;
    ImageView imgBrandLogo;
    private SwipeRefreshLayout layout1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venroute_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();

        layout1 = findViewById(R.id.layout1);

        layout1.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                layout1.setRefreshing(false);
            }
        });
        brandLogo = intent.getStringExtra("brandLogo");
        brandName = intent.getStringExtra("brandName");
        getSupportActionBar().setTitle(brandName);

        imgBrandLogo = (ImageView) findViewById(R.id.bannerLogo);

        Glide.with(this)
                .load(RestApi.BASE_URL + brandLogo)
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .fitCenter()
//                .placeholder(R.drawable.nav_profile)
                .error(R.drawable.nav_profile)
                .into(imgBrandLogo);


        VenrouteBannerDetailFragment venrouteBannerDetailFragment = new VenrouteBannerDetailFragment();
        Bundle bundle = new Bundle();
//        bundle.putString("brandName", brandName);
        venrouteBannerDetailFragment.setArguments(intent.getExtras());

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment, venrouteBannerDetailFragment);
        fragmentTransaction.commit();

    }

}

