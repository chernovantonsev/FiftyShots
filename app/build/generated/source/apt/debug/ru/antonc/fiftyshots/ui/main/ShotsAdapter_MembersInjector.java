package ru.antonc.fiftyshots.ui.main;

import android.content.Context;
import dagger.MembersInjector;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@Generated(
  value = "dagger.internal.codegen.ComponentProcessor",
  comments = "https://google.github.io/dagger"
)
public final class ShotsAdapter_MembersInjector implements MembersInjector<ShotsAdapter> {
  private final Provider<Context> mContextProvider;

  private final Provider<OkHttpClient.Builder> clientProvider;

  public ShotsAdapter_MembersInjector(
      Provider<Context> mContextProvider, Provider<OkHttpClient.Builder> clientProvider) {
    this.mContextProvider = mContextProvider;
    this.clientProvider = clientProvider;
  }

  public static MembersInjector<ShotsAdapter> create(
      Provider<Context> mContextProvider, Provider<OkHttpClient.Builder> clientProvider) {
    return new ShotsAdapter_MembersInjector(mContextProvider, clientProvider);
  }

  @Override
  public void injectMembers(ShotsAdapter instance) {
    injectMContext(instance, mContextProvider.get());
    injectClient(instance, clientProvider.get());
  }

  public static void injectMContext(ShotsAdapter instance, Context mContext) {
    instance.mContext = mContext;
  }

  public static void injectClient(ShotsAdapter instance, OkHttpClient.Builder client) {
    instance.client = client;
  }
}