package ru.antonc.fiftyshots.ui.main;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.antonc.fiftyshots.data.rest.ShotsService;
import ru.antonc.fiftyshots.ui.base.BasePresenter_MembersInjector;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainPresenter_MembersInjector implements MembersInjector<MainPresenter> {
  private final Provider<ShotsService> mShotsServiceProvider;

  public MainPresenter_MembersInjector(Provider<ShotsService> mShotsServiceProvider) {
    this.mShotsServiceProvider = mShotsServiceProvider;
  }

  public static MembersInjector<MainPresenter> create(
      Provider<ShotsService> mShotsServiceProvider) {
    return new MainPresenter_MembersInjector(mShotsServiceProvider);
  }

  @Override
  public void injectMembers(MainPresenter instance) {
    BasePresenter_MembersInjector.injectMShotsService(instance, mShotsServiceProvider.get());
  }
}