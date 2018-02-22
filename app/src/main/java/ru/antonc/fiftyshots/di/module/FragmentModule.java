package ru.antonc.fiftyshots.di.module;

import android.content.Context;
import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;
import ru.antonc.fiftyshots.di.qualifier.FragmentContext;
import ru.antonc.fiftyshots.di.scope.PerFragment;

/**
 * Created by antonc on 21.02.2018.
 */
@Module
public class FragmentModule {

    private Fragment mFragment;

    public FragmentModule(Fragment fragment) {
        mFragment = fragment;
    }

    @Provides
    @PerFragment
    Fragment providesFragment() {
        return mFragment;
    }


    @Provides
    @PerFragment
    @FragmentContext
    Context providesContext() {
        return mFragment.getActivity();
    }
}
