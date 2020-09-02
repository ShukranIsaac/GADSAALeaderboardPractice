package com.practice.gadsaaleaderboard.ui.splash;

import android.os.Bundle;

import com.practice.gadsaaleaderboard.ui.common.BaseActivity;
import com.practice.gadsaaleaderboard.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }
}