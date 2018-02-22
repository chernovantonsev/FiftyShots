package ru.antonc.fiftyshots.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import dagger.Module;
import dagger.Provides;
import ru.antonc.fiftyshots.di.scope.PerActivity;

/**
 * Created by antonc on 21.02.2018.
 */
@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        mActivity = activity;
    }

    @Provides
    @PerActivity
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    @PerActivity
    Context providesContext() {
        return mActivity;
    }
}
