package com.practice.gadsaaleaderboard.ui.common;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;

public final class BaseContracts {
    public interface View {
        Context getContext();

        BaseActivity getBaseActivity();

        void startActivity(@NonNull Class<?> destination,
                           @Nullable Bundle bundle,
                           boolean finishCurrent, boolean finishAll,
                           @Nullable ActivityOptionsCompat transition);

        void onBackPressed();
    }

    public interface Presenter {
        void onDetach();
    }
}
