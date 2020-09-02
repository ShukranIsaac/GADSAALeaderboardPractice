package com.practice.gadsaaleaderboard;

import android.os.Bundle;

import com.practice.gadsaaleaderboard.ui.common.BaseActivity;
import com.practice.gadsaaleaderboard.ui.main.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }

}