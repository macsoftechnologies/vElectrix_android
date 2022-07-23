package com.macsoftech.vihaan.activities;

import android.os.Bundle;

import com.macsoftech.vihaan.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem;
import np.com.susanthapa.curved_bottom_navigation.CurvedBottomNavigationView;

public class DashboardJavaActivity extends BaseActivity {


    @BindView(R.id.nav_view)
    CurvedBottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getSupportActionBar().hide();

        bottomNavigationView.setMenuItems(new CbnMenuItem[]{
                new CbnMenuItem(R.drawable.animated_dashboard, R.drawable.animated_dashboard, 0),
                new CbnMenuItem(R.drawable.animated_home, R.drawable.animated_home, 0),
                new CbnMenuItem(R.drawable.animated_profile, R.drawable.animated_profile, 0),
        }, 0);
//        bottomNavigationView.setOnClickListener(view -> {
//
//        });
//        bottomNavigationView.setOnMenuItemClickListener(
//                (cbnMenuItem, i) -> {
//
//                }
//        );
    }


}