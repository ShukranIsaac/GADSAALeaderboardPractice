package com.practice.gadsaaleaderboard.ui.main;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import timber.log.Timber;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.practice.gadsaaleaderboard.Leader;
import com.practice.gadsaaleaderboard.OnItemClickListener;
import com.practice.gadsaaleaderboard.R;
import com.practice.gadsaaleaderboard.databinding.LeadersFragmentBinding;
import com.practice.gadsaaleaderboard.ui.ViewModelFactory;

public class LeadersFragment extends Fragment implements OnItemClickListener<Leader> {
    private LeadersViewModel mViewModel;
    private LeadersFragmentBinding mBinding;
    private LeaderRecyclerAdapter mRecyclerAdapter;

    private LeadersFragment() {
        super();
    }

    public static LeadersFragment newInstance() {
        return new LeadersFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding= DataBindingUtil.inflate(inflater, R.layout.leaders_fragment, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(LeadersViewModel.class);

        setUpLeadersRecyclerView();

        mRecyclerAdapter.submitList(null);
    }

    private void setUpLeadersRecyclerView() {
        mRecyclerAdapter = new LeaderRecyclerAdapter(getContext());
        mRecyclerAdapter.setOnItemClickListener(this);
        mBinding.recyclerView.setAdapter(mRecyclerAdapter);
    }

    @Override
    public void onItemClick(Leader model) {
        Timber.d(model.badgeUrl());
        Toast.makeText(getContext(), String.format("%s Clicked!", model.name()), Toast.LENGTH_SHORT)
                .show();
    }
}