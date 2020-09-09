package com.practice.gadsaaleaderboard.ui.projectsubmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;

import com.practice.gadsaaleaderboard.R;
import com.practice.gadsaaleaderboard.databinding.ActivityProjectBinding;
import com.practice.gadsaaleaderboard.ui.ViewModelFactory;
import com.practice.gadsaaleaderboard.ui.common.OnDialogClickListener;

import java.util.Objects;

public final class ProjectActivity extends SubmissionAlertDialog implements ProjectContracts.View {
    private static final String TAG = ProjectActivity.class.getSimpleName();
    private ProjectViewModel mViewModel;
    private ActivityProjectBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_project);

        Toolbar toolbar = mBinding.toolbar;
        toolbar.setLogo(ResourcesCompat.getDrawable(getResources(), R.drawable.gads_header, null));
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);

        mViewModel = new ViewModelProvider(this, new ViewModelFactory()).get(ProjectViewModel.class);

        mViewModel.getFormStateMutableLiveData().observe(this, projectFormState -> {
            if (projectFormState == null) {
                return;
            }

            mBinding.project.button.setEnabled(projectFormState.isDataValid());
            if (projectFormState.getEmailError() != null) {
                mBinding.project.emailAddress.setError(getString(projectFormState.getEmailError()));
            }

            if (projectFormState.getFirstNameError() != null) {
                mBinding.project.firstName.setError(getString(projectFormState.getFirstNameError()));
            }

            if (projectFormState.getLastNameError() != null) {
                mBinding.project.lastName.setError(getString(projectFormState.getLastNameError()));
            }

            if (projectFormState.getGithubLinkError() != null) {
                mBinding.project.githubLink.setError(getString(projectFormState.getGithubLinkError()));
            }
        });

        mBinding.project.firstName.addTextChangedListener(afterTextChangedListener);
        mBinding.project.lastName.addTextChangedListener(afterTextChangedListener);
        mBinding.project.emailAddress.addTextChangedListener(afterTextChangedListener);
        mBinding.project.githubLink.addTextChangedListener(afterTextChangedListener);
    }

    TextWatcher afterTextChangedListener = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            // ignore
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            // ignore
        }

        @Override
        public void afterTextChanged(Editable s) {
            mViewModel.formProjectDataChanged(
                    mBinding.project.emailAddress.getText().toString(),
                    mBinding.project.firstName.getText().toString(),
                    mBinding.project.lastName.getText().toString(),
                    mBinding.project.githubLink.getText().toString());
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.init(this);
        mBinding.project.setMView(this);
    }

    public void onClickProjectSubmit() {
        showInfoDialog("Are you sure?", new OnDialogClickListener() {
            @Override
            public void onPositiveClick(AlertDialog alertDialog) {
                mViewModel.submitProject(LeaderPayloadAttr.builder()
                        .email(mBinding.project.emailAddress.getText().toString())
                        .track("AAD - Android Associate Developer")
                        .firstName(mBinding.project.firstName.getText().toString())
                        .lastName(mBinding.project.lastName.getText().toString())
                        .githubLink(mBinding.project.githubLink.getText().toString())
                        .build());
                alertDialog.dismiss();
            }

            @Override
            public void onNegativeClick(AlertDialog alertDialog) {
                alertDialog.dismiss();
            }
        }).show();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void success() {
        showInfoDialog(getString(R.string.submission_success), ResourcesCompat.getDrawable(getResources(),
                R.drawable.ic_baseline_check_circle_24, null), ResourcesCompat.getColor(getResources(),
                R.color.colorPrimary_2e7, null));
        mBinding.project.emailAddress.setText(null);
        mBinding.project.lastName.setText(null);
        mBinding.project.firstName.setText(null);
        mBinding.project.githubLink.setText(null);
    }

    @Override
    public void failure() {
        showInfoDialog(getString(R.string.submission_failure), ResourcesCompat.getDrawable(getResources(),
                R.drawable.ic_baseline_report_problem_24, null), ResourcesCompat.getColor(getResources(),
                R.color.colorPrimaryRed, null));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}