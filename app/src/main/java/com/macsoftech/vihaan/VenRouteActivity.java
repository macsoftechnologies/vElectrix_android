package com.macsoftech.vihaan;

import android.os.Bundle;
import android.view.Window;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.macsoftech.vihaan.fragment.VenrouteBannerFragment;

public class VenRouteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_venroute);

        //VenrouteBannerFragment venrouteBannerFragment = new VenrouteBannerFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment,new VenrouteBannerFragment());
        fragmentTransaction.commit();

    }

}

