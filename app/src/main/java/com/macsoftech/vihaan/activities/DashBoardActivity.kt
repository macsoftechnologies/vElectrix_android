package com.macsoftech.vihaan.activities

import android.os.Bundle
import butterknife.ButterKnife
import com.macsoftech.vihaan.R
import com.macsoftech.vihaan.fragment.DashboardFragment
import com.macsoftech.vihaan.fragment.HomeFragment
import com.macsoftech.vihaan.fragment.ProfileFragment
import np.com.susanthapa.curved_bottom_navigation.CbnMenuItem
import np.com.susanthapa.curved_bottom_navigation.CurvedBottomNavigationView

public class DashBoardActivity : BaseActivity() {
    //    @BindView(R.id.nav_view)
    var bottomNavigationView: CurvedBottomNavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        supportActionBar!!.hide()
        bottomNavigationView = findViewById<CurvedBottomNavigationView>(R.id.nav_view);
        bottomNavigationView?.setMenuItems(
            arrayOf(
                CbnMenuItem(R.drawable.animated_dashboard, R.drawable.animated_dashboard, 0),
                CbnMenuItem(R.drawable.animated_home, R.drawable.animated_home, 0),
                CbnMenuItem(R.drawable.animated_profile, R.drawable.animated_profile, 0)
            ), 0
        )
        bottomNavigationView?.setOnMenuItemClickListener { cbnMenuItem, i ->
            run {
                addReplaceFragment(i);
            }
        }
        addReplaceFragment(0);
    }

    fun addReplaceFragment(index: Int) {
        if (index == 0) {
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.container, DashboardFragment())
                .commitAllowingStateLoss()
        } else if (index == 1) {
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.container, HomeFragment())
                .commitAllowingStateLoss()

        } else {
            supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.container, ProfileFragment())
                .commitAllowingStateLoss()

        }

    }
}