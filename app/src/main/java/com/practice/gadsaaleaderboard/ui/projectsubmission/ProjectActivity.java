package com.practice.gadsaaleaderboard.ui.projectsubmission;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import timber.log.Timber;

import android.os.Bundle;
import android.view.MenuItem;

import com.practice.gadsaaleaderboard.R;
import com.practice.gadsaaleaderboard.databinding.ActivityProjectBinding;
import com.practice.gadsaaleaderboard.ui.ViewModelFactory;

import java.util.Objects;

public final class ProjectActivity extends AppCompatActivity implements ProjectContracts.View {
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

        mViewModel = new ViewModelProvider(this, new ViewModelFactory())
                .get(ProjectViewModel.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mViewModel.init(this);
        mBinding.project.setMView(this);
    }

    @Override
    public void submitProject() {
        mViewModel.submitProject(LeaderPayloadAttr.builder().build());
    }

    @Override
    public void success() {

    }

    @Override
    public void failure() {

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) onBackPressed();

        return super.onOptionsItemSelected(item);
    }
}