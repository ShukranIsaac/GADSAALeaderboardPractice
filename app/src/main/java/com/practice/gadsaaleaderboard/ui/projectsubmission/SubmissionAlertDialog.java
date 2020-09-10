package com.practice.gadsaaleaderboard.ui.projectsubmission;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.practice.gadsaaleaderboard.R;
import com.practice.gadsaaleaderboard.databinding.DialogStatusBodyBinding;
import com.practice.gadsaaleaderboard.ui.common.listeners.OnDialogClickListener;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public abstract class SubmissionAlertDialog extends AppCompatActivity implements ProjectContracts.AlertDialogView {

    @Override
    public void showInfoDialog(String message, Drawable layout_body, int color) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        final DialogStatusBodyBinding binding = DataBindingUtil.inflate(LayoutInflater.from(this),
                R.layout.dialog_status_body, null, false);

        binding.setBackground(layout_body);
        binding.setBackgroundTint(color);
        binding.setMessage(message);

        alertDialog.setView(binding.getRoot());

        alertDialog.show();
    }

    @Override
    public AlertDialog showInfoDialog(String message, OnDialogClickListener dialogListener) {

        AlertDialog alertDialog = new AlertDialog.Builder(this).create();

        // Header
        final View headerView = LayoutInflater.from(this).inflate(R.layout.dialog_header, null);
        headerView.findViewById(R.id.dialogCancel).setOnClickListener(view -> {
            dialogListener.onNegativeClick(alertDialog);
            alertDialog.dismiss();
        });

        alertDialog.setCustomTitle(headerView);

        final View bodyView = LayoutInflater.from(this).inflate(R.layout.dialog_body, null);
        ((TextView) bodyView.findViewById(R.id.dialogText)).setText(message);
        bodyView.findViewById(R.id.dialogAccept).setOnClickListener(view -> {
            dialogListener.onPositiveClick(alertDialog);
            alertDialog.dismiss();
        });

        alertDialog.setView(bodyView);

        return alertDialog;
    }

}
