package com.practice.gadsaaleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.practice.gadsaaleaderboard.databinding.MainActivityBinding;
import com.practice.gadsaaleaderboard.ui.main.LeadersFragment;
import com.practice.gadsaaleaderboard.ui.splash.SplashActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        setSupportActionBar(binding.toolbar);

        ViewPager viewPager = binding.viewPager;
        setViewPager(viewPager);
        binding.tabs.setupWithViewPager(viewPager);
    }

    private void setViewPager(ViewPager viewPager) {
        // TODO: Fit each tab half the width: only two tabs
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.add("Learning Leaders", LeadersFragment.newInstance());
        pagerAdapter.add("Skill IQ Leaders", LeadersFragment.newInstance());
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.action_submit)
            startActivity(new Intent(this, SplashActivity.class));

        return super.onOptionsItemSelected(item);
    }
}