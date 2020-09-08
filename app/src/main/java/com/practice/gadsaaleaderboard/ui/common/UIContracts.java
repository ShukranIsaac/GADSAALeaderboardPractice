package com.practice.gadsaaleaderboard.ui.common;

public class UIContracts {
    public interface View {
        void setLoader(boolean bool);
        void setError(Throwable throwable);
    }

    public interface Presenter {}
}
