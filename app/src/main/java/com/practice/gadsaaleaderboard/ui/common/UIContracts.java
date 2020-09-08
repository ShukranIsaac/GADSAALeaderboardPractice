package com.practice.gadsaaleaderboard.ui.common;

import com.practice.gadsaaleaderboard.Leader;

import java.util.ArrayList;

import timber.log.Timber;

public class UIContracts {
    public interface View {
        void setLoader(boolean bool);
        void setLeaders(ArrayList<Leader> leaderArrayList);
        void setError(Throwable throwable);
        static void setError(String message) {
            Timber.d(message);
        }
    }
}
