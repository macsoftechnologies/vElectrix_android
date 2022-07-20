package com.macsoftech.vihaan.app;

import androidx.multidex.MultiDexApplication;

import com.macsoftech.vihaan.helper.Helper;


/**
 * Created by Ramesh on 06/10/17.
 */

public class BaseApp extends MultiDexApplication {

    private static BaseApp instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

    }

    public static BaseApp getInstance() {
        return instance;
    }

    public static boolean hasNetwork() {
        return Helper.isNetworkAvailable(instance);
    }
}
