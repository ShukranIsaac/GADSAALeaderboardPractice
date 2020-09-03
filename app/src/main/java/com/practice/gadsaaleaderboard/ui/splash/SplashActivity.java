package com.practice.gadsaaleaderboard.ui.splash;

import android.os.Bundle;

import com.practice.gadsaaleaderboard.ui.common.BaseActivity;
import com.practice.gadsaaleaderboard.R;

import androidx.databinding.DataBindingUtil;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.SplashTheme);
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_splash);
    }
}