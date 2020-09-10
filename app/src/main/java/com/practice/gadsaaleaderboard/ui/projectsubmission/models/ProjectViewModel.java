package com.practice.gadsaaleaderboard.ui.projectsubmission.models;

import android.util.Patterns;
import android.widget.Toast;

import com.practice.gadsaaleaderboard.R;
import com.practice.gadsaaleaderboard.common.Api;
import com.practice.gadsaaleaderboard.common.helpers.Constant;
import com.practice.gadsaaleaderboard.common.room.AppDatabase;
import com.practice.gadsaaleaderboard.common.schedulers.SchedulerProvider;
import com.practice.gadsaaleaderboard.ui.projectsubmission.ProjectContracts;
import com.practice.gadsaaleaderboard.ui.projectsubmission.ProjectFormState;
import com.practice.gadsaaleaderboard.ui.projectsubmission.ProjectRepository;
import com.practice.gadsaaleaderboard.ui.projectsubmission.SubmitService;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public final class ProjectViewModel extends ViewModel {
    private static final String TAG = ProjectViewModel.class.getSimpleName();

    private MutableLiveData<ProjectFormState> mFormStateMutableLiveData = new MutableLiveData<>();
    private ProjectRepository repository;
    private SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mDisposable;
    private ProjectContracts.View mView;

    public ProjectViewModel() { }

    public void init(ProjectContracts.View view) {
        this.mView = view;
        this.mDisposable = new CompositeDisposable();
        this.mSchedulerProvider = SchedulerProvider.get();
    }

    public ProjectViewModel(ProjectRepository repository) {
        this.repository = repository;
        this.mDisposable = new CompositeDisposable();
        this.mSchedulerProvider = SchedulerProvider.get();
    }

    public MutableLiveData<ProjectFormState> getFormStateMutableLiveData() {
        return mFormStateMutableLiveData;
    }

    public void formProjectDataChanged(String email, String firstname, String lastname, String github_link) {
        if (firstname.length() == 0) {
            mFormStateMutableLiveData.setValue(new ProjectFormState(R.string.invalid_first_name,
                    null, null, null));
        } else if (lastname.length() == 0) {
            mFormStateMutableLiveData.setValue(new ProjectFormState(null,
                    R.string.invalid_last_name, null, null));
        } else if (!isEmailValid(email)) {
            mFormStateMutableLiveData.setValue(new ProjectFormState(null,
                    null, email.length() == 0 ? R.string.invalid_email_re
                    : R.string.invalid_email, null));
        } else if (github_link.length() == 0) {
            mFormStateMutableLiveData.setValue(new ProjectFormState(null,
                    null, null, R.string.invalid_github_link));
        } else {
            mFormStateMutableLiveData.setValue(new ProjectFormState(true));
        }
    }

    public void submitProject(LeaderPayloadAttr payloadAttr) {
        mDisposable.add(Api.getInstance()
                .create(Constant.SUBMIT_BASE_URL, SubmitService.class)
                .submitProject(payloadAttr.email(), payloadAttr.firstName(),
                        payloadAttr.lastName(), payloadAttr.github_link())
                .subscribeOn(mSchedulerProvider.io()).observeOn(mSchedulerProvider.ui())
                .subscribe(responseBody -> mView.success(), throwable -> {
                    Toast.makeText(mView.getContext(), mView.getContext()
                                    .getString(R.string.submission_failure_tmessage),
                            Toast.LENGTH_LONG).show();
                    mView.failure();
                })
        );
    }

    public LiveData<List<LeaderPayloadAttr>> projects() {
        return AppDatabase.getInstance(mView.getContext())
                .projects().findAll();
    }

    private boolean isEmailValid(String email) {
        if (email.length() == 0) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}