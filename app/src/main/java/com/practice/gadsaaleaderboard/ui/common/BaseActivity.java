package com.practice.gadsaaleaderboard.ui.common;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import com.practice.gadsaaleaderboard.BuildConfig;
import com.practice.gadsaaleaderboard.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;

public class BaseActivity extends AppCompatActivity implements BaseContracts.View {
    private BehaviorSubject<Status> lifeCycleObservable = BehaviorSubject.create();
    private boolean isLoading = false;

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

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
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

    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInfoDialog(String title, String message) {

    }

    @Override
    public AlertDialog showInfoDialog(String title, String message,
                                      OnDialogClickListener dialogListener) {
        return null;
    }

    @Override
    public void error(Throwable throwable) {

    }

    @Override
    public AlertDialog showInfoDialog(String title, String message, String positiveButtonText,
                                      String negativeButtonText, OnDialogClickListener clickListener) {
        return null;
    }
}
