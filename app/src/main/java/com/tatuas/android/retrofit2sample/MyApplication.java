package com.tatuas.android.retrofit2sample;

import android.app.Application;
import android.support.annotation.NonNull;
import android.util.Log;

import com.jakewharton.threetenabp.AndroidThreeTen;

import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        setupAndroidThreeTen();
        setupFinalLandfillSiteOfRxThrowable();
    }

    private void setupAndroidThreeTen() {
        AndroidThreeTen.init(this);
    }

    private void setupFinalLandfillSiteOfRxThrowable() {
        RxJavaPlugins.setErrorHandler(new Consumer<Throwable>() {
            @Override
            public void accept(@NonNull Throwable throwable) throws Exception {
                Log.d("final landfill site", throwable.toString());
            }
        });
    }
}
