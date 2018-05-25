package ru.antonc.fiftyshots.di.component;

import dagger.Subcomponent;
import ru.antonc.fiftyshots.di.module.ActivityModule;
import ru.antonc.fiftyshots.di.module.FragmentModule;
import ru.antonc.fiftyshots.di.scope.ConfigPersistent;

@ConfigPersistent
@Subcomponent
public interface ConfigPersistentComponent {

    ActivityComponent activityComponent(ActivityModule activityModule);

    FragmentComponent fragmentComponent(FragmentModule fragmentModule);

}
