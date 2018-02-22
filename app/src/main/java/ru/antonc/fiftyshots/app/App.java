package ru.antonc.fiftyshots.app;

import android.app.Application;
import android.content.Context;

import ru.antonc.fiftyshots.di.component.ApplicationComponent;
import ru.antonc.fiftyshots.di.component.DaggerApplicationComponent;
import ru.antonc.fiftyshots.di.module.ApplicationModule;

public class App extends Application {

    private ApplicationComponent mApplicationComponent;


    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this))
                    .build();
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }


}
