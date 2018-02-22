package ru.antonc.fiftyshots.ui.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import sev.com.fiftyshots.R;
import ru.antonc.fiftyshots.di.component.ActivityComponent;
import ru.antonc.fiftyshots.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            openFragment();
        }
    }

    @Override
    protected void openFragment() {
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(MainFragment.class.getName());
        if (fragment == null)
            fragment = new MainFragment();

        fm.beginTransaction()
                .replace(R.id.container, fragment, MainFragment.class.getName())
                .commitAllowingStateLoss();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void inject(ActivityComponent activityComponent) {
        activityComponent.inject(this);
    }

    @Override
    protected void attachView() {

    }

    @Override
    protected void detachPresenter() {

    }
}