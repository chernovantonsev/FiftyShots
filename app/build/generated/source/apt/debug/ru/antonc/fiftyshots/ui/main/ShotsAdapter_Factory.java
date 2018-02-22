package ru.antonc.fiftyshots.ui.main;

import android.content.Context;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ShotsAdapter_Factory implements Factory<ShotsAdapter> {
  private final Provider<Context> mContextProvider;

  private final Provider<OkHttpClient.Builder> clientProvider;

  public ShotsAdapter_Factory(
      Provider<Context> mContextProvider, Provider<OkHttpClient.Builder> clientProvider) {
    this.mContextProvider = mContextProvider;
    this.clientProvider = clientProvider;
  }

  @Override
  public ShotsAdapter get() {
    ShotsAdapter instance = new ShotsAdapter();
    ShotsAdapter_MembersInjector.injectMContext(instance, mContextProvider.get());
    ShotsAdapter_MembersInjector.injectClient(instance, clientProvider.get());
    return instance;
  }

  public static ShotsAdapter_Factory create(
      Provider<Context> mContextProvider, Provider<OkHttpClient.Builder> clientProvider) {
    return new ShotsAdapter_Factory(mContextProvider, clientProvider);
  }

  public static ShotsAdapter newShotsAdapter() {
    return new ShotsAdapter();
  }
}
