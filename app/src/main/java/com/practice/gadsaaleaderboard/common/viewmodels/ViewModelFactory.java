package com.practice.gadsaaleaderboard.common.viewmodels;

import com.practice.gadsaaleaderboard.ui.main.LeaderRepository;
import com.practice.gadsaaleaderboard.ui.main.LeadersViewModel;
import com.practice.gadsaaleaderboard.ui.projectsubmission.ProjectRepository;
import com.practice.gadsaaleaderboard.ui.projectsubmission.ProjectViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

/**
 * ViewModel provider factory to instantiate ViewModel.
 * Required given ViewModel has a non-empty constructor
 */
public class ViewModelFactory implements BaseViewModelFactory {
    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(ProjectViewModel.class)) {
            return (T) new ProjectViewModel(new ProjectRepository());
        } else if (modelClass.isAssignableFrom(LeadersViewModel.class)) {
            return (T) new LeadersViewModel(new LeaderRepository());
        }else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
