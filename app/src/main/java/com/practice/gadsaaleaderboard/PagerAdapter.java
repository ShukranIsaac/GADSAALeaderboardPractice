package com.practice.gadsaaleaderboard;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragments;
    private List<String> fragmentTitles;

    public PagerAdapter(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        this.fragments = new ArrayList<>();
        this.fragmentTitles = new ArrayList<>();
    }

    public void add(String title, Fragment fragment) {
        fragmentTitles.add(title);
        fragments.add(fragment);
    }

    public Fragment getFragment(int pos) {
        return fragments.get(pos);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitles.get(position);
    }
}
