package com.practice.gadsaaleaderboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.practice.gadsaaleaderboard.databinding.MainActivityBinding;
import com.practice.gadsaaleaderboard.ui.ViewModelFactory;
import com.practice.gadsaaleaderboard.ui.main.LeadersViewModel;
import com.practice.gadsaaleaderboard.ui.main.LearningFragment;
import com.practice.gadsaaleaderboard.ui.main.SkillIQFragment;
import com.practice.gadsaaleaderboard.ui.splash.SplashActivity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private LeadersViewModel mViewModel;
    private MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        setSupportActionBar(binding.toolbar);

        mViewModel = new ViewModelProvider(this, new ViewModelFactory())
                .get(LeadersViewModel.class);

        binding.tabs.setupWithViewPager(setViewPager(binding.viewPager));
    }

    private ViewPager setViewPager(ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.add("Learning Leaders", LearningFragment.newInstance(mViewModel));
        pagerAdapter.add("Skill IQ Leaders", SkillIQFragment.newInstance(mViewModel));
        viewPager.setAdapter(pagerAdapter);
        return viewPager;
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