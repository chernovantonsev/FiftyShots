package ru.antonc.fiftyshots.di.component;

import dagger.Subcomponent;
import ru.antonc.fiftyshots.di.module.FragmentModule;
import ru.antonc.fiftyshots.di.module.PresenterModule;
import ru.antonc.fiftyshots.di.scope.PerFragment;
import ru.antonc.fiftyshots.ui.main.MainFragment;

/**
 * Created by antonc on 21.02.2018.
 */
@PerFragment
@Subcomponent(modules = {FragmentModule.class, PresenterModule.class})
public interface FragmentComponent {

    void inject(MainFragment mainFragment);
}
