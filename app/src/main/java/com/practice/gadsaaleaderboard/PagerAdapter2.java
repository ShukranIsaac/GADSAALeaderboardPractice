package com.practice.gadsaaleaderboard;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public final class PagerAdapter2 extends FragmentStateAdapter {
    private List<Fragment> fragments;
    private List<String> fragmentTitles;

    public void add(String title, Fragment fragment) {
        fragmentTitles.add(title);
        fragments.add(fragment);
    }

    public PagerAdapter2(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
        this.fragments = new ArrayList<>();
        this.fragmentTitles = new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return fragments.get(position);
    }

    @Override
    public int getItemCount() {
        return fragmentTitles.size();
    }
}
