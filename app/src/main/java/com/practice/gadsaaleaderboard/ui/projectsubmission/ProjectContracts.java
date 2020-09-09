package com.practice.gadsaaleaderboard.ui.projectsubmission;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.practice.gadsaaleaderboard.ui.common.OnDialogClickListener;

import androidx.appcompat.app.AlertDialog;

public class ProjectContracts {

    public interface View {
        Context getContext();

        void success();

        void failure();

        void onClickProjectSubmit();
    }

    public interface AlertDialogView {
        void showInfoDialog(String message, Drawable layout_body, int color);

        AlertDialog showInfoDialog(String message, OnDialogClickListener dialogListener);
    }

}



