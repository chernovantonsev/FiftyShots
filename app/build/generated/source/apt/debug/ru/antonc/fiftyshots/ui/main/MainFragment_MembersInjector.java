package ru.antonc.fiftyshots.ui.main;

import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class MainFragment_MembersInjector implements MembersInjector<MainFragment> {
  private final Provider<IMainContract.Presenter> mPresenterProvider;

  private final Provider<ShotsAdapter> mAdapterProvider;

  public MainFragment_MembersInjector(
      Provider<IMainContract.Presenter> mPresenterProvider,
      Provider<ShotsAdapter> mAdapterProvider) {
    this.mPresenterProvider = mPresenterProvider;
    this.mAdapterProvider = mAdapterProvider;
  }

  public static MembersInjector<MainFragment> create(
      Provider<IMainContract.Presenter> mPresenterProvider,
      Provider<ShotsAdapter> mAdapterProvider) {
    return new MainFragment_MembersInjector(mPresenterProvider, mAdapterProvider);
  }

  @Override
  public void injectMembers(MainFragment instance) {
    injectMPresenter(instance, mPresenterProvider.get());
    injectMAdapter(instance, mAdapterProvider.get());
  }

  public static void injectMPresenter(MainFragment instance, IMainContract.Presenter mPresenter) {
    instance.mPresenter = mPresenter;
  }

  public static void injectMAdapter(MainFragment instance, ShotsAdapter mAdapter) {
    instance.mAdapter = mAdapter;
  }
}
