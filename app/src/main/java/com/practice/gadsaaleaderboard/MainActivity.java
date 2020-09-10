package com.practice.gadsaaleaderboard;

import android.content.Intent;
import android.os.Bundle;

import com.practice.gadsaaleaderboard.databinding.MainActivityBinding;
import com.practice.gadsaaleaderboard.common.viewmodels.ViewModelFactory;
import com.practice.gadsaaleaderboard.ui.common.adapters.PagerAdapter;
import com.practice.gadsaaleaderboard.ui.main.LeadersViewModel;
import com.practice.gadsaaleaderboard.ui.main.LearningFragment;
import com.practice.gadsaaleaderboard.ui.main.SkillIQFragment;
import com.practice.gadsaaleaderboard.ui.projectsubmission.ProjectActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private LeadersViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivityBinding binding = DataBindingUtil.setContentView(this, R.layout.main_activity);

        mViewModel = new ViewModelProvider(this, new ViewModelFactory())
                .get(LeadersViewModel.class);

        binding.tabs.setupWithViewPager(setViewPager(binding.viewPager));

        binding.submit.setOnClickListener(v -> startActivity(new Intent(this,
                ProjectActivity.class)));
    }

    private ViewPager setViewPager(ViewPager viewPager) {
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        pagerAdapter.add("Learning Leaders", LearningFragment.newInstance(mViewModel));
        pagerAdapter.add("Skill IQ Leaders", SkillIQFragment.newInstance(mViewModel));
        viewPager.setAdapter(pagerAdapter);
        return viewPager;
    }
}