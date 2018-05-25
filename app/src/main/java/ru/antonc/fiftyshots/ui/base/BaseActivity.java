package ru.antonc.fiftyshots.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.util.LongSparseArray;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.atomic.AtomicLong;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import ru.antonc.fiftyshots.app.App;
import ru.antonc.fiftyshots.di.component.ActivityComponent;
import ru.antonc.fiftyshots.di.component.ConfigPersistentComponent;
import ru.antonc.fiftyshots.di.module.ActivityModule;

/**
 * Created by antonc on 21.02.2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements IBaseView {

    private static final String KEY_ACTIVITY_ID = "KEY_ACTIVITY_ID";
    private static final AtomicLong NEXT_ID = new AtomicLong(0);
    private static final LongSparseArray<ConfigPersistentComponent> componentsArray = new LongSparseArray<>();

    private long activityId;

    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        mUnbinder = ButterKnife.bind(this);

        activityId =
                savedInstanceState != null
                        ? savedInstanceState.getLong(KEY_ACTIVITY_ID)
                        : NEXT_ID.getAndIncrement();
        ConfigPersistentComponent configPersistentComponent;
        if (componentsArray.get(activityId) == null) {
            configPersistentComponent =
                    App.get(this).getComponent().configPersistentComponent();
            componentsArray.put(activityId, configPersistentComponent);
        } else {
            configPersistentComponent = componentsArray.get(activityId);
        }
        ActivityComponent activityComponent =
                configPersistentComponent.activityComponent(new ActivityModule(this));
        inject(activityComponent);
        attachView();
    }

    protected abstract int getLayout();

    protected abstract void inject(ActivityComponent activityComponent);

    protected abstract void attachView();

    protected abstract void detachPresenter();

    protected abstract void openFragment();

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong(KEY_ACTIVITY_ID, activityId);
    }

    @Override
    protected void onDestroy() {
        if (!isChangingConfigurations()) {
            componentsArray.remove(activityId);
        }
        detachPresenter();
        mUnbinder.unbind();
        super.onDestroy();
    }


}
