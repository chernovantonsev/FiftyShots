package ru.antonc.fiftyshots.ui.main;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.antonc.fiftyshots.data.rest.ShotsService;
import ru.antonc.fiftyshots.ui.base.BasePresenter_MembersInjector;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainPresenter_Factory implements Factory<MainPresenter> {
  private final Provider<Context> contextProvider;

  private final Provider<ShotsService> mShotsServiceProvider;

  public MainPresenter_Factory(
      Provider<Context> contextProvider, Provider<ShotsService> mShotsServiceProvider) {
    this.contextProvider = contextProvider;
    this.mShotsServiceProvider = mShotsServiceProvider;
  }

  @Override
  public MainPresenter get() {
    MainPresenter instance = new MainPresenter(contextProvider.get());
    BasePresenter_MembersInjector.injectMShotsService(instance, mShotsServiceProvider.get());
    return instance;
  }

  public static MainPresenter_Factory create(
      Provider<Context> contextProvider, Provider<ShotsService> mShotsServiceProvider) {
    return new MainPresenter_Factory(contextProvider, mShotsServiceProvider);
  }

  public static MainPresenter newMainPresenter(Context context) {
    return new MainPresenter(context);
  }
}
