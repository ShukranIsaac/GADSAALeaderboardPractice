package com.practice.gadsaaleaderboard.ui.main;

import com.practice.gadsaaleaderboard.Leader;
import com.practice.gadsaaleaderboard.LeaderBoardService;
import com.practice.gadsaaleaderboard.common.Api;
import com.practice.gadsaaleaderboard.common.schedulers.SchedulerProvider;
import com.practice.gadsaaleaderboard.ui.common.UIContracts;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class LeadersViewModel extends ViewModel {
    // TODO: Implement the ViewModel, AutoWire the LeaderRepository
    private LeaderRepository repository;
    private SchedulerProvider mSchedulerProvider;
    private CompositeDisposable mDisposable;
    private UIContracts.View mView;

    public LeadersViewModel() { }

    public void init(UIContracts.View view) {
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
    }

    public LiveData<List<Leader>> leaderBoardHours() {
        return new MutableLiveData<>();
    }

    public void getLeaderBoardSkillIQs() {
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
                }));
    }

    public LiveData<List<Leader>> leaderBoardSkillIQs() {
        return new MutableLiveData<>();
    }
}