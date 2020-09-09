package com.practice.gadsaaleaderboard.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.practice.gadsaaleaderboard.MainActivity;
import com.practice.gadsaaleaderboard.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.activity_splash);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, 2000);
    }

}