package com.practice.gadsaaleaderboard.ui.main;

import com.practice.gadsaaleaderboard.ui.main.models.LeadersViewModel;

public final class SkillIQFragment extends BaseLeadersFragment {
    public SkillIQFragment(LeadersViewModel mViewModel) {
        super(mViewModel);
    }

    public static SkillIQFragment newInstance(LeadersViewModel mViewModel) {
        return new SkillIQFragment(mViewModel);
    }

    @Override
    public void onResume() {
        super.onResume();
        getViewModel().getLeaderBoardSkillIQs();
    }
}
