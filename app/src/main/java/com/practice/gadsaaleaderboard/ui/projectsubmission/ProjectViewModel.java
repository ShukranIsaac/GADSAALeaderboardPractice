package com.practice.gadsaaleaderboard.ui.projectsubmission;

import com.practice.gadsaaleaderboard.common.schedulers.SchedulerProvider;

import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;
import timber.log.Timber;

public final class ProjectViewModel extends ViewModel {
    private static final String TAG = ProjectViewModel.class.getSimpleName();
    // TODO: Implement the ViewModel, AutoWire the ProjectRepository
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

    public void submitProject(LeaderPayloadAttr payloadAttr) {
        Timber.d("%s: %s", TAG, payloadAttr.toString());
//        mDisposable.add(Api.getInstance()
//                .create(Constant.SUBMIT_BASE_URL, SubmitService.class)
//                .merchantRest(payloadAttr.firstName(),
//                        payloadAttr.lastName(),
//                        payloadAttr.personalFone(),
//                        payloadAttr.businessName(),
//                        payloadAttr.locationOfBusiness(),
//                        payloadAttr.businessEmail(),
//                        payloadAttr.businessPhone(),
//                        payloadAttr.govermentStat(),
//                        payloadAttr.additionalInfor())
//                .subscribeOn(mSchedulerProvider.io())
//                .observeOn(mSchedulerProvider.ui())
//                .subscribe(responseBody -> {
//
//                        },
//                        throwable -> {
//
//                        })
//        );
    }
}