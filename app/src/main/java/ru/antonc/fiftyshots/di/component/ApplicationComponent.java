package ru.antonc.fiftyshots.di.component;


import javax.inject.Singleton;

import dagger.Component;
import ru.antonc.fiftyshots.di.module.ApplicationModule;
import ru.antonc.fiftyshots.di.module.NetModule;

/**
 * Created by antonc on 21.02.2018.
 */
@Singleton
@Component(modules = {ApplicationModule.class,  NetModule.class})
public interface ApplicationComponent {


    ConfigPersistentComponent configPersistentComponent();
}
