package ru.antonc.fiftyshots.ui.base;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import ru.antonc.fiftyshots.data.rest.ShotsService;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class BasePresenter_MembersInjector<T extends IBaseView>
    implements MembersInjector<BasePresenter<T>> {
  private final Provider<ShotsService> mShotsServiceProvider;

  public BasePresenter_MembersInjector(Provider<ShotsService> mShotsServiceProvider) {
    this.mShotsServiceProvider = mShotsServiceProvider;
  }

  public static <T extends IBaseView> MembersInjector<BasePresenter<T>> create(
      Provider<ShotsService> mShotsServiceProvider) {
    return new BasePresenter_MembersInjector<T>(mShotsServiceProvider);
  }

  @Override
  public void injectMembers(BasePresenter<T> instance) {
    injectMShotsService(instance, mShotsServiceProvider.get());
  }

  public static <T extends IBaseView> void injectMShotsService(
      BasePresenter<T> instance, ShotsService mShotsService) {
    instance.mShotsService = mShotsService;
  }
}
