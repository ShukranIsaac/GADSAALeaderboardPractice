package com.practice.gadsaaleaderboard.common.schedulers;

import androidx.annotation.NonNull;
import io.reactivex.Scheduler;

public abstract class SchedulerProvider {

    public static SchedulerProvider get() {
        return new SchedulersProviderImpl();
    }

    @NonNull
    public abstract Scheduler computation();

    @NonNull
    public abstract Scheduler io();

    @NonNull
    public abstract Scheduler ui();

}
