package com.practice.gadsaaleaderboard.common;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.practice.gadsaaleaderboard.BuildConfig;
import com.practice.gadsaaleaderboard.common.helpers.StrictModePolicy;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;
import timber.log.Timber;

public class App extends MultiDexApplication {
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(BuildConfig.DEBUG ? new Timber.DebugTree() : null);

        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this);
            StrictModePolicy.getThreadPolicy();
            StrictModePolicy.getVmPolicy();
        }
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
