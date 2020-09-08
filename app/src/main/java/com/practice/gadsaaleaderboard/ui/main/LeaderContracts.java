package com.practice.gadsaaleaderboard.ui.main;

import com.practice.gadsaaleaderboard.ui.common.UIContracts;

import java.util.ArrayList;

import timber.log.Timber;

public class LeaderContracts {
    public interface View extends UIContracts.View {
        void setLeaders(ArrayList<Leader> leaderArrayList);
        static void setError(String message) {
            Timber.d(message);
        }
    }

    public interface Presenter extends UIContracts.Presenter { }
}
