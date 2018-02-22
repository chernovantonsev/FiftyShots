package ru.antonc.fiftyshots.di.module;

import dagger.Binds;
import dagger.Module;
import ru.antonc.fiftyshots.ui.main.IMainContract;
import ru.antonc.fiftyshots.ui.main.MainPresenter;

/**
 * Created by antonc on 21.02.2018.
 */
@Module
public abstract class PresenterModule {

    @Binds
    abstract IMainContract.Presenter bindMainPresenter(MainPresenter mainPresenter);

}
