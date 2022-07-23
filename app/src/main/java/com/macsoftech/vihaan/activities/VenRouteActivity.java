package com.macsoftech.vihaan.activities;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.macsoftech.vihaan.R;
import com.macsoftech.vihaan.fragment.VenrouteBannerFragment;

public class VenRouteActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venroute);
//        getSupportActionBar().hide();
        getSupportActionBar().setTitle("VENROUTE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //VenrouteBannerFragment venrouteBannerFragment = new VenrouteBannerFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new VenrouteBannerFragment());
        fragmentTransaction.commit();

    }

}

