package com.practice.gadsaaleaderboard.ui.common;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityOptionsCompat;

public class BaseContracts {
    public interface View {
        Context getContext();

        BaseActivity getBaseActivity();

        void startActivity(@NonNull Class<?> destination, @Nullable Bundle bundle,
                           boolean finishCurrent, boolean finishAll,
                           @Nullable ActivityOptionsCompat transition);

        void back();

        void showInfoDialog(String title, String message);

        AlertDialog showInfoDialog(String title, String message, OnDialogClickListener dialogListener);

        void showToast(String message);

        void error(Throwable throwable);

        AlertDialog showInfoDialog(String title, String message,
                                   String positiveButtonText, String negativeButtonText,
                                   OnDialogClickListener clickListener);
    }

    public interface Presenter {
        void onDetach();
    }
}
