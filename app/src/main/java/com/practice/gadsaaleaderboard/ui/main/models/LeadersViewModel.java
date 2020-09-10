package com.practice.gadsaaleaderboard.ui.main.models;

import com.practice.gadsaaleaderboard.common.Api;
import com.practice.gadsaaleaderboard.common.room.AppDatabase;
import com.practice.gadsaaleaderboard.common.schedulers.SchedulerProvider;
import com.practice.gadsaaleaderboard.ui.main.LeaderBoardService;
import com.practice.gadsaaleaderboard.ui.main.LeaderContracts;
import com.practice.gadsaaleaderboard.ui.main.LeaderRepository;
import com.practice.gadsaaleaderboard.ui.main.models.Leader;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class LeadersViewModel extends ViewModel {
    // TODO: Implement the ViewModel to use the LeaderRepository methods
    private LeaderRepository repository;
    private SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mDisposable;
    private LeaderContracts.View mView;

    public LeadersViewModel() { }

    public void init(LeaderContracts.View view) {
        this.mView = view;
        this.mDisposable = new CompositeDisposable();
        this.mSchedulerProvider = SchedulerProvider.get();
    }

    public LeadersViewModel(LeaderRepository repository) {
        this.repository = repository;
        this.mDisposable = new CompositeDisposable();
        this.mSchedulerProvider = SchedulerProvider.get();
    }

    public void getLeaderBoardHours() {
        mView.setLoader(true);
        mDisposable.add(Api.getInstance().create(LeaderBoardService.class)
                .leaderBoardHours()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(leaders -> {
                    mView.setLoader(false);
                    mView.setLeaders(leaders);
                }, throwable -> {
                    mView.setLoader(false);
                    mView.setError(throwable);
                }));

//        Observable<ArrayList<Leader>> listLeadersHours = Api.getInstance()
//                .create(LeaderBoardService.class).leaderBoardHours();
//
//        Observable<ArrayList<Leader>> listLeadersIQs = Api.getInstance()
//                .create(LeaderBoardService.class).leaderBoardSkillIQs();
//
//        mDisposable.add(Observable.mergeDelayError(listLeadersHours.doOnNext(leaders -> AppDatabase.getInstance(mView.getContext())
//                        .leaders().insert(leaders)).subscribeOn(mSchedulerProvider.io()),
//                listLeadersIQs.doOnNext(leaders -> AppDatabase.getInstance(mView.getContext())
//                        .leaders().insert(leaders))
//                        .subscribeOn(mSchedulerProvider.io()))
//                .subscribe(leaders -> {
//                    mView.setLoader(false);
//                    mView.setLeaders(leaders);
//                }, throwable -> {
//                    mView.setLoader(false);
//                    mView.setError(throwable);
//                }));
    }

    public LiveData<List<Leader>> leaderBoardHours() {
        return AppDatabase.getInstance(mView.getContext())
                .leaders().findAll();
    }

    public void getLeaderBoardSkillIQs() {
        mView.setLoader(true);
        mDisposable.add(Api.getInstance().create(LeaderBoardService.class)
                .leaderBoardSkillIQs()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(leaders -> {
                    mView.setLoader(false);
                    mView.setLeaders(leaders);
                }, throwable -> {
                    mView.setLoader(false);
                    mView.setError(throwable);
                })
        );
    }

    public LiveData<List<Leader>> leaderBoardSkillIQs() {
        return AppDatabase.getInstance(mView.getContext())
                .leaders().findAll();
    }

    public void dispose() {
        if (mDisposable != null)
            mDisposable.clear();
    }
}