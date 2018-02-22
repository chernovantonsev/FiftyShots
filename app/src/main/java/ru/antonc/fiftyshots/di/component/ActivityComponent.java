package ru.antonc.fiftyshots.di.component;


import dagger.Subcomponent;
import ru.antonc.fiftyshots.di.module.ActivityModule;
import ru.antonc.fiftyshots.di.module.PresenterModule;
import ru.antonc.fiftyshots.di.scope.PerActivity;
import ru.antonc.fiftyshots.ui.main.MainActivity;

/**
 * Created by antonc on 21.02.2018.
 */
@PerActivity
@Subcomponent(modules = {ActivityModule.class, PresenterModule.class})
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
