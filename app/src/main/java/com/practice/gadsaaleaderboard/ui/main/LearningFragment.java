package com.practice.gadsaaleaderboard.ui.main;

import com.practice.gadsaaleaderboard.ui.main.models.LeadersViewModel;

public final class LearningFragment extends BaseLeadersFragment {
    public LearningFragment(LeadersViewModel mViewModel) {
        super(mViewModel);
    }

    public static LearningFragment newInstance(LeadersViewModel mViewModel) {
        return new LearningFragment(mViewModel);
    }

    @Override
    public void onResume() {
        super.onResume();
        getViewModel().getLeaderBoardHours();
    }
}
