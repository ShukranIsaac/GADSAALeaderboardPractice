package com.practice.gadsaaleaderboard.ui.main;

import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import timber.log.Timber;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.practice.gadsaaleaderboard.ui.common.listeners.OnItemClickListener;
import com.practice.gadsaaleaderboard.R;
import com.practice.gadsaaleaderboard.databinding.LeadersFragmentBinding;

import java.util.ArrayList;

public abstract class BaseLeadersFragment extends Fragment
        implements OnItemClickListener<Leader>, LeaderContracts.View {
    private static final String TAG = BaseLeadersFragment.class.getSimpleName();
    private LeadersViewModel mViewModel;
    private LeadersFragmentBinding mBinding;
    private LeaderRecyclerAdapter mRecyclerAdapter;
    private LinearLayoutManager mLayoutManager;

    private BaseLeadersFragment() {
        super();
    }

    public BaseLeadersFragment(LeadersViewModel mViewModel) {
        this.mViewModel = mViewModel;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding= DataBindingUtil.inflate(inflater, R.layout.leaders_fragment, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mLayoutManager = new LinearLayoutManager(getContext());

        setUpLeadersRecyclerView();
    }

    private void setUpLeadersRecyclerView() {
        mRecyclerAdapter = new LeaderRecyclerAdapter(getContext());
        mRecyclerAdapter.setOnItemClickListener(this);
        mBinding.recyclerView.setLayoutManager(mLayoutManager);
        mBinding.recyclerView.setAdapter(mRecyclerAdapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        mViewModel.init(this);
    }

    @Nullable
    @Override
    public Context getContext() {
        return super.getContext();
    }

    @Override
    public void onItemClick(Leader model) {
        Toast.makeText(getContext(), String.format("%s Clicked!",
                model.name()), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setLoader(boolean bool) {
        if (!bool) {
            mBinding.loader.setVisibility(View.GONE);
        } else {
            mBinding.loader.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void setLeaders(ArrayList<Leader> leaderArrayList) {
        mRecyclerAdapter.submitList(leaderArrayList);
    }

    @Override
    public void setError(Throwable throwable) {
        Timber.d("%s: %s", TAG, throwable.getMessage());
    }

    protected LeadersViewModel getViewModel() {
        return mViewModel;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mViewModel.dispose();
    }
}