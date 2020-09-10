package com.practice.gadsaaleaderboard.common.viewmodels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public interface BaseViewModelFactory extends ViewModelProvider.Factory {
    @NonNull
    @Override
    <T extends ViewModel> T create(@NonNull Class<T> modelClass);
}
