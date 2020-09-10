package com.practice.gadsaaleaderboard.ui.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.practice.gadsaaleaderboard.BuildConfig;
import com.practice.gadsaaleaderboard.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class BaseActivity extends AppCompatActivity implements BaseContracts.View {
    private BehaviorSubject<Status> lifeCycleObservable = BehaviorSubject.create();

    public enum Status {
        ON_PAUSE,
        ON_RESUME
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (!getResources().getBoolean(R.bool.is_tablet))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        if (!BuildConfig.DEBUG)
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE,
                    WindowManager.LayoutParams.FLAG_SECURE);

        new StethoInterceptor();

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifeCycleObservable.onNext(Status.ON_RESUME);
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifeCycleObservable.onNext(Status.ON_PAUSE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public Context getContext() {
        return this;
    }

    public BaseActivity getBaseActivity() {
        return BaseActivity.this;
    }

    public void startActivity(@NonNull Class<?> destination, @Nullable Bundle bundle,
                              boolean finishCurrent, boolean finishAll,
                              @Nullable ActivityOptionsCompat transition) {
        Intent intent = new Intent(this, destination);
        if (finishAll)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (bundle != null)
            intent.putExtras(bundle);
        if (transition != null)
            ContextCompat.startActivity(this, intent, transition.toBundle());
        else
            ContextCompat.startActivity(this, intent, null);
        if (finishCurrent)
            finish();
    }

    public BaseActivity getBaseContext() {
        return this;
    }

    public void back() {
        finish();
    }

    public Observable<Status> observableLifeCycle() {
        return lifeCycleObservable;
    }

    public void hideKeyboard() {
        if (getCurrentFocus() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            if (inputMethodManager != null)
                inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }
}
